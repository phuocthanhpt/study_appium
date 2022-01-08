package appium_related.test;

import appium_related.driver.DriverFactory;
import appium_related.models.pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginFormTest {
    public static void main(String[] args) {

        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        try {
//            MobileElement loginLabelElement = androidDriver.findElementByAccessibilityId("Login");
//            loginLabelElement.click();

            LoginPage loginPage = new LoginPage(androidDriver);
            loginPage.bottomNavigationComponent().clickOnLoginLabel();
            loginPage
                    .inputUsername("teo@sth.com")
                    .inputPassword("876554321")
                    .clickOnLoginBtnElem();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
