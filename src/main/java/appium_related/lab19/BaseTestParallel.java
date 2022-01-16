package appium_related.lab19;

import appium_related.driver.DriverFactoryEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTestParallel {

    private DriverFactoryEx driverFactoryEx;
    private AppiumDriver<MobileElement> appiumDriver;

    private final List<DriverFactoryEx> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private ThreadLocal<DriverFactoryEx> driverThread;

    private String udid;
    private String systemPort;

    @BeforeClass(alwaysRun = true)
    @Parameters({"udid", "systemPort"})
    public void beforeClass(String udid, String systemPort){
        this.udid = udid;
        this.systemPort = systemPort;
        System.out.println(udid + " - " + systemPort);
        driverThread = ThreadLocal.withInitial(()->{
            DriverFactoryEx driverThread = new DriverFactoryEx();
            driverThreadPool.add(driverThread);
            return driverThread;
        });
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driverThread.get().quitAppiumSession();
    }

    protected AppiumDriver<MobileElement> getAndroidDriver(){
        if(appiumDriver== null){
            appiumDriver = driverThread.get().getAndroidDriver(udid, systemPort);
        }
        return appiumDriver;
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult){
        if(iTestResult.getStatus()==ITestResult.FAILURE){
           String testMethodName = iTestResult.getName();

            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            String dateTaken = y + "_" + m + "_" + d + "_" + hr + "_" + min + "_" + sec;

            String fileLocation = System.getProperty("user.dir") + "/screenshots/" +
                    testMethodName + "_" + dateTaken + ".png";

            File screenShot = driverThread.get().getAndroidDriver().getScreenshotAs(OutputType.FILE);

            try{
                FileUtils.copyFile(screenShot, new File(fileLocation));
                Path content = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(content);
                Allure.addAttachment(testMethodName, inputStream);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
