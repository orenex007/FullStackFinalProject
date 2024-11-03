package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonOps;

import java.time.Duration;

public class MobileActions extends CommonOps {
    @Step("Update Text Mobile Element")
    public static void updateText(MobileElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
//        elem.clear(); // Clear the field before sending new text
        elem.sendKeys(text);
    }

    @Step("Tap on Element")
    public static void tap(MobileElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        TouchAction action = new TouchAction(mobileDriver);
        action.tap((new TapOptions())
                .withElement(ElementOption.element(elem)))
                .perform();
    }

    @Step("Android Key Back")
    public static void androidKeyBack(){
        mobileDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    @Step("Swipe")
    public static void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 300; // ms

        final int PRESS_TIME = 300; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    @Step("Zoom Element")
    public static void zoom(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getX() + elem.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                .withElement(elem).withCoordinates(x, y - 10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y - 100));
        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                .withElement(elem).withCoordinates(x, y + 10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y + 100));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }
    @Step("Pinch Element")
    public static void pinch(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getX() + elem.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                .withElement(elem).withCoordinates(x, y - 100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y - 10));
        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                .withElement(elem).withCoordinates(x, y + 100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y + 10));

        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

}
