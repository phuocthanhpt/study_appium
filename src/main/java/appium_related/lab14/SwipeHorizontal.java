package appium_related.lab14;

import appium_related.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SwipeHorizontal {
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
        int xStartPoint = (90 * screenWidth)/100;
        int xEndPoint = (10 * screenWidth)/100;
        int yStartPoint = (50 * screenHeight)/100;
        int yEndPoint = yStartPoint;

        // Convert to PointOptions - Coordinates
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        // Perform actions (press -> move up -> release)
        TouchAction touchAction = new TouchAction(androidDriver);
        final int MAX_SWIPE_TIME = 5;
        int swipeTime = 0;

        while(swipeTime < MAX_SWIPE_TIME){
            List<MobileElement> matchedElemens = androidDriver.findElementsByXPath("//*[@text='EXTENDABLE']");
            if(!matchedElemens.isEmpty()) break;

            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();
            swipeTime++;
        }

        if(swipeTime == 10){
            throw new RuntimeException("Card not found");
        }
    }
}
