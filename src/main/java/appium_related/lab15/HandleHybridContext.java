package appium_related.lab15;

import appium_related.driver.DriverFactory;
import contexts.AppContexts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HandleHybridContext implements AppContexts {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();

        try {
            // Click on Login label
            MobileElement webviewLabelElem = androidDriver.findElementByAccessibilityId("Webview");
            webviewLabelElem.click();

            WebDriverWait wait = new WebDriverWait(androidDriver, 10L);
            wait.until(moreThanOneContext(androidDriver));

            androidDriver.getContextHandles().forEach(System.out::println);

            androidDriver.context(WEB);
            WebElement navToggleBtn = androidDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtn.click();

            List<MobileElement> menuItems = androidDriver.findElementsByCssSelector(".menu__list-item a");
            List<MenuItem> menuItemList = new ArrayList<>();
            if (menuItems.isEmpty()) throw new RuntimeException("[Error] Menu item is empty");
            menuItems.forEach(menuItem -> {
                String itemText = menuItem.getText();
                String itemHyperLink  = menuItem.getAttribute("href");

                if(StringUtils.isEmpty(itemText))
                    menuItemList.add(new MenuItem("GitHub", itemHyperLink));
                else
                    menuItemList.add(new MenuItem(itemText, itemHyperLink));
            });

            menuItemList.forEach(menuItemData -> {
                System.out.println(menuItemData);
            });

            // Switch back to Native
            androidDriver.context(NATIVE);
            androidDriver.findElementByAccessibilityId("Login").click();

            Thread.sleep(3000);

            // Put app runs in background
            androidDriver.runAppInBackground(Duration.ofSeconds(3));

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            androidDriver.quit();
            ;
        }
    }

    private static ExpectedCondition<Boolean> moreThanOneContext(AppiumDriver<MobileElement> appiumDriver) {
        return driver -> appiumDriver.getContextHandles().size() > 1;
    }

    public static class MenuItem {
        private String text;
        private String hyperLink;

        public MenuItem(String text, String hyperLink) {
            this.text = text;
            this.hyperLink = hyperLink;
        }

        @Override
        public String toString() {
            return "MenuItem{" +
                    "text='" + text + '\'' +
                    ", hyperLink='" + hyperLink + '\'' +
                    '}';
        }
    }
}
