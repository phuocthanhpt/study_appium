package appium_related.lab18;

import appium_related.driver.DriverFactory;
import appium_related.lab17.LoginCredential;
import appium_related.models.BaseTest;
import appium_related.models.pages.LoginPage;
import appium_related.test_flows.authentication.LoginFlow;
import appium_related.utils.data.DataObjectBuilder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class LoginTestWithBaseTest extends BaseTest {

    @Test
    public void loginWithValidCredential() {
        String jsonLocation = "/src/main/java/resources/test-data/LoginCredential.json";
        LoginCredential loginCredentialData = DataObjectBuilder.buildDataObject(jsonLocation, LoginCredential[].class)[0];

        AppiumDriver<MobileElement> androidDriver = getAndroidDriver();

        LoginFlow loginFlow = new LoginFlow(androidDriver, loginCredentialData);
        loginFlow.login(loginCredentialData).verifyLogin();
    }

    @Test
    public void testGoToLoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getAndroidDriver());
        loginPage.bottomNavigationComponent().clickOnFormsLabel();
        Thread.sleep(3000);
    }


}
