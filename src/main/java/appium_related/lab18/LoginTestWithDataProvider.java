package appium_related.lab18;

import appium_related.driver.DriverFactory;
import appium_related.lab17.LoginCredential;
import appium_related.models.BaseTest;
import appium_related.models.pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.util.Arrays;

public class LoginTestWithDataProvider extends BaseTest {
    static{
        loginCredentialData = Arrays.asList(new LoginCredential("", ""), new LoginCredential("teo@sth.com", "87654321"));
    }

    @Test
    public void loginWithInvalidCredential(){
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        for(LoginCredential loginCred : loginCredentialData){
            LoginPage loginPage = new LoginPage(androidDriver);
            loginPage.bottomNavigationComponent().clickOnLoginLabel();
            loginPage
                    .inputUsername(loginCred.getUsername())
                    .inputPassword(loginCred.getPassword())
                    .clickOnLoginBtnElem();
        }
    }
}
