package appium_related.lab15;

import appium_related.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class HandleMultipleApps {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        try {
            // ON app: go to Login page
            MobileElement loginLabelElement = androidDriver.findElementByAccessibilityId("Login");
            loginLabelElement.click();

            MobileElement username = androidDriver.findElementByAccessibilityId("input-email");
            MobileElement password = androidDriver.findElementByAccessibilityId(("input-password"));
            MobileElement loginBtn = androidDriver.findElementByAccessibilityId("button-LOGIN");

            username.sendKeys("teo@sth.abc");
            password.sendKeys("87654321");
            loginBtn.click();

            Thread.sleep(3000);

            // Put app into background
            androidDriver.runAppInBackground(Duration.ofSeconds(-1));

            // Go to Settings -> Wifi

            // Active app
            androidDriver.activateApp("com.android.settings");

            androidDriver.findElementByXPath("//*[@text='Connections']").click();
            androidDriver.findElementByXPath("//*[@text='Wi-Fi']").click();
            MobileElement wifiSwitchButtonElement = androidDriver.findElement(By.id("com.android.settings:id/switch_widget"));
            boolean isWifiOn = wifiSwitchButtonElement.getText().equals("ON");
            wifiSwitchButtonElement.click();
            if (isWifiOn) wifiSwitchButtonElement.click();

            androidDriver.activateApp("com.wdiodemoapp");

            androidDriver.findElementByXPath("//*[@text='OK']").click();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
