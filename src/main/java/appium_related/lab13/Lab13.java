package appium_related.lab13;

import appium_related.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class Lab13 {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        try {
            // Click on Login label
            MobileElement loginLabelElement = androidDriver.findElementByAccessibilityId("Login");
            loginLabelElement.click();

            MobileElement username = androidDriver.findElementByAccessibilityId("input-email");
            MobileElement password = androidDriver.findElementByAccessibilityId(("input-password"));
            MobileElement loginBtn = androidDriver.findElementByAccessibilityId("button-LOGIN");

            username.sendKeys("teo");
            password.sendKeys("87654321");
            loginBtn.click();

            final int EMAIL_FIELD_INDEX = 0;
            final int PASSWORD_FIELD_INDEX = 1;
            List<MobileElement> loginInputFormElem = androidDriver.findElements(By.xpath("//android.widget.EditText"));
            if(loginInputFormElem.isEmpty()){
                throw new RuntimeException("Login form elements can't be found");
            }else{
                loginInputFormElem.get(EMAIL_FIELD_INDEX).sendKeys("teo@sth.com");
                loginInputFormElem.get(PASSWORD_FIELD_INDEX).sendKeys("87654321");
            }

//            username.sendKeys("teo@sth.com");
//            password.sendKeys("87654321");
            loginBtn.click();

            MobileElement loginDialogTitleElem = androidDriver.findElement(By.id("android:id/alertTitle111"));
            System.out.println("Login Title: " + loginDialogTitleElem.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            androidDriver.quit();
        }
    }
}
