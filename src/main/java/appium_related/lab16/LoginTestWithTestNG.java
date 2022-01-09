package appium_related.lab16;

import appium_related.driver.DriverFactory;
import appium_related.models.pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class LoginTestWithTestNG {

    @Test
    public void loginWithValidCredentialTest(){
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        try {
            LoginPage loginPage = new LoginPage(androidDriver);
            loginPage.bottomNavigationComponent().clickOnLoginLabel();
            loginPage
                    .inputUsername("teo@sth.com")
                    .inputPassword("876554321")
                    .clickOnLoginBtnElem();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            androidDriver.quit();
        }
    }

    @Test
    public void test02(){
        System.out.println("test 02");
    }
}
