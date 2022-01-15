package appium_related.lab19;

import appium_related.driver.DriverFactoryEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
}
