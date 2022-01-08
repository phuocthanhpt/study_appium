package appium_related.lab15;

import appium_related.driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TakingSreenshot {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();

        try{
            AppiumDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

            // ON app: go to Login page
            MobileElement loginLabelElement = androidDriver.findElementByAccessibilityId("Login");
            loginLabelElement.click();

            WebDriverWait wait = new WebDriverWait(androidDriver, 10L);
            WebElement loginBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("button-LOGIN")));

            // Taking screenshot - whole screen
            File base64Sreenshot = androidDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("FullLoginScreen.png");
            FileUtils.copyFile(base64Sreenshot, new File(fileLocation));

            // Taking screenshot on an element
//            MobileElement loginBtnElement = androidDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64LoginBtn = loginBtnElement.getScreenshotAs(OutputType.FILE);
            String loginBtnFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginButton.png");
            FileUtils.copyFile(base64LoginBtn, new File(loginBtnFileLocation));

            // Taking screenshot on an area
            MobileElement loginScreen = androidDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64loginScreen= loginScreen.getScreenshotAs(OutputType.FILE);
            String loginScreenFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("OnlyLoginForm.png");
            FileUtils.copyFile(base64loginScreen, new File(loginScreenFileLocation));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
