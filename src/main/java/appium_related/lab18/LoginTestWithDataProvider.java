package appium_related.lab18;

import appium_related.driver.DriverFactory;
import appium_related.lab17.LoginCredential;
import appium_related.models.pages.LoginPage;
import appium_related.utils.data.DataObjectBuilder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestWithDataProvider{

    @Test(dataProvider = "invalidLoginData")
    public void loginWithInvalidCredential(LoginCredential loginCredentialData) {
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        LoginPage loginPage = new LoginPage(androidDriver);
        loginPage.bottomNavigationComponent().clickOnLoginLabel();
        loginPage
                .inputUsername(loginCredentialData.getUsername())
                .inputPassword(loginCredentialData.getPassword())
                .clickOnLoginBtnElem();
    }

    @DataProvider
    public LoginCredential[] invalidLoginData() {
        String jsonLocation = "/src/main/java/resources/test-data/LoginInvalidCredential.json";
        return DataObjectBuilder.buildDataObject(jsonLocation, LoginCredential[].class);
    }
}
