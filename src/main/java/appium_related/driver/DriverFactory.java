package appium_related.driver;

import appium_related.caps.MobileCapabilityTypeEx;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AppiumDriverLocalService appiumDriverLocalService;
    private static AndroidDriver<MobileElement> androidDriver;

    public static void startAppiumServer(){
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress("127.0.0.1").usingAnyFreePort();
//        appiumServiceBuilder.withIPAddress("127.0.0.1").usingPort(4723);
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
    }

    public static void stopAppiumServer(){
        String killNodeWindowsCommand = "taskkill /F /IM node.exe";
        String killNodeLinuxCommand = "killall node";
        String killNodeCmd = System.getProperty("os.name").toLowerCase().startsWith("windows")
                ? killNodeWindowsCommand : killNodeLinuxCommand;
        Runtime runtime = Runtime.getRuntime();
        try{
            runtime.exec(killNodeCmd);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static AndroidDriver<MobileElement> getAndroidDriver(){
        initAndroidDriver();
        return androidDriver;
    }

    private static void initAndroidDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.UDID, "33000a201bf1b35b");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");

        androidDriver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), desiredCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
    }
}
