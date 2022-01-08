package appium_related.models.pages;

import appium_related.models.components.global.BottomNavigationComponent;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage {

    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By usernameSel = MobileBy.AccessibilityId("input-email");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginPage(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    // Return found elements
    private MobileElement usernameElem(){
        return appiumDriver.findElement(usernameSel);
    }

    public LoginPage inputUsername(String username){
        usernameElem().sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password){
        appiumDriver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public void clickOnLoginBtnElem(){
        appiumDriver.findElement(loginBtnSel).click();
    }

    public BottomNavigationComponent bottomNavigationComponent(){
        return new BottomNavigationComponent(appiumDriver);
    }
}
