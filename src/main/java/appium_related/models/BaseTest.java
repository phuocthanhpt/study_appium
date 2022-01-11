package appium_related.models;

import appium_related.driver.DriverFactoryEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private DriverFactoryEx driverFactoryEx;
    private AppiumDriver<MobileElement> appiumDriver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        driverFactoryEx = new DriverFactoryEx();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driverFactoryEx.quitAppiumSession();
    }

    protected AppiumDriver<MobileElement> getAndroidDriver(){
        if(appiumDriver== null){
            appiumDriver = driverFactoryEx.getAndroidDriver();
        }
        return appiumDriver;
    }
}
