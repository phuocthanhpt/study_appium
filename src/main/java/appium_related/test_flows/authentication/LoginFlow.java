package appium_related.test_flows.authentication;

import appium_related.lab17.LoginCredential;
import appium_related.models.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginFlow {

    // Must initial object states/attributes

    private final AppiumDriver<MobileElement> appiumDriver;
    private final LoginCredential loginCredentialData;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, LoginCredential loginCredentialData) {
        this.appiumDriver = appiumDriver;
        this.loginCredentialData = loginCredentialData;
    }

    public LoginFlow login(LoginCredential loginCredentialData){
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.bottomNavigationComponent().clickOnLoginLabel();
        loginPage
                .inputUsername(loginCredentialData.getUsername())
                .inputPassword(loginCredentialData.getPassword())
                .clickOnLoginBtnElem();

        return this;
    }

    public void verifyLogin(){
        boolean isEmailInvalid = isEmailInvalid(loginCredentialData.getUsername());
        boolean isPasswordInvalid = isPasswordInvalid(loginCredentialData.getPassword());

        if(isEmailInvalid)
            verifyInvalidEmailFormat();
        if(isPasswordInvalid)
            verifyInvalidPasswordFormat();
        if(!isEmailInvalid && !isPasswordInvalid)
            verifyLoginSuccess();
    }

    private void verifyLoginSuccess() {
    }

    private void verifyInvalidPasswordFormat() {
    }

    private void verifyInvalidEmailFormat() {
    }

    private boolean isPasswordInvalid(String password) {
        return true;
    }

    private boolean isEmailInvalid(String username) {
        return true;
    }
}
