package appium_related.lab14;

import appium_related.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwipeUtils {
    public static void main(String[] args) throws InterruptedException {
        DriverFactory.startAppiumServer();
        AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();
        MobileElement swipeLabel = androidDriver.findElementByAccessibilityId("Swipe");
        swipeLabel.click();

        // Make sure on correct screen
        WebDriverWait wait = new WebDriverWait(androidDriver, 10L);


        // Get Mobile size
        Dimension windowSize = androidDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Calculate touch points
        int xStartPoint = (50 * screenWidth)/100;
        int xEndPoint = xStartPoint;
        int yStartPoint = (50 * screenHeight)/100;
        int yEndPoint = (10 * screenHeight)/100;

        // Convert to PointOptions - Coordinates
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        // Perform actions (press -> move up -> release)
        TouchAction touchAction = new TouchAction(androidDriver);
        final int MAX_SWIPE_TIME = 10;
        int swipeTime = 0;

        while(swipeTime < MAX_SWIPE_TIME){
            List<MobileElement> matchedElemens = androidDriver.findElementsByXPath("//*[@text='You found me!!!']");
            if(!matchedElemens.isEmpty()) break;

            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();
            swipeTime++;
        }

        if(swipeTime == 10){
            throw new RuntimeException("Icon not found");
        }
    }
}
