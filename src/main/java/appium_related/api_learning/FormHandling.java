package appium_related.api_learning;

import appium_related.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormHandling {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        try{
            // Click on Login label
            MobileElement loginLabelElement = androidDriver.findElementByAccessibilityId("Login");
            loginLabelElement.click();

            MobileElement username = androidDriver.findElementByAccessibilityId("input-email");
            MobileElement password = androidDriver.findElementByAccessibilityId(("input-password"));
            MobileElement loginBtn = androidDriver.findElementByAccessibilityId("button-LOGIN");

            username.sendKeys("teo");
            password.sendKeys("87654321");
            loginBtn.click();

            // clear
            username.sendKeys("teo@sth.com");
            password.sendKeys("87654321");
            loginBtn.click();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            androidDriver.quit();
        }


    }
}
