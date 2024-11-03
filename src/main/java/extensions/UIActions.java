package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UIActions extends CommonOps {
    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        System.out.println("Clicking on element: " + elem);
        elem.click();
    }
    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
//        System.out.println("Updating text field: " + elem + " with text: " + text);
        elem.clear(); // Clear the field before sending new text
        elem.sendKeys(text);
    }
//    @Step("Update DropDown Element")
//    public static void updateDropDown(WebElement elem, String text){
//        //some wait
////        System.out.println("Updating dropdown field: " + elem + " with text: " + text);
//        Select dropDown = new Select(elem);
//        dropDown.deselectByVisibleText(text);
////        dropDown.selectByVisibleText(text); // Use selectByVisibleText instead of deselectByVisibleText
//
//    }
    @Step("Delete Text In The Element With Red Button Element")
    public static void deleteTextInTheInput(WebElement elem){
//        System.out.println("Deleting input field: " + elem);
        elem.clear();
    }


    @Step("Mouse Hover Element To About Website")
    public static void mouseHover(WebElement elem1, WebElement elem2, WebElement elem3, WebElement elem4){
        action.moveToElement(elem1).moveToElement(elem2).moveToElement(elem3).moveToElement(elem4).click().build().perform();
    }

    @Step("Mouse Hover Element")
    public static void navigateBackInWindow(){
        driver.navigate().back();
    }

    @Step("Scroll Down Element")
    public static void scrollDown(){
        ((JavascriptExecutor)driver).executeScript("scrollTo(0,1000)");
    }

//    @Step("Get Current URL")
//    public static void getUrl(){
//        driver.getCurrentUrl();
//    }

    @Step("Get Current Tab")
    public static String getCurrentTab(){
        return driver.getWindowHandle();
    }

    @Step("Navigate To New Tab")
    public static void navigateToNewTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    @Step("Navigate To New Tab")
    public static void navigateToOriginal(String handle) {
        driver.switchTo().window(handle);
    }

    @Step("Get The Title From The Website")
    public static String getTitleFromWebsite() {
        return driver.getTitle();
    }
    @Step("Key RETURN in the keyboard")
    public static void actionKeysRETURN() {
        action.sendKeys(Keys.ESCAPE).perform();
    }
    @Step("close the tab")
    public static void closeTab() {
        driver.close();
    }  

//    @Step("Key ENTER in the keyboard")
//    public static void actionKeysENTER() {
//        action.sendKeys(Keys.ENTER).perform();
//    }
//
//    @Step("Key ESCAPE in the keyboard")
//    public static void actionKeysESCAPE() {
//        action.sendKeys(Keys.ESCAPE).perform();
//    }


    //======================== UIAction For Electron ========================
    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value){
        elem.sendKeys(value);
    }

    //======================== UIAction For Desktop ========================
    @Step("Insert Key Without WebElement(for Desktop apps)")
    public static void insertKeyWithoutWebElement(Keys key) {
        try {
            switch (key) {
                case NUMPAD1:
                    robot.keyPress(KeyEvent.VK_NUMPAD1);
                    robot.keyRelease(KeyEvent.VK_NUMPAD1);
                    break;
                case NUMPAD2:
                    robot.keyPress(KeyEvent.VK_NUMPAD2);
                    robot.keyRelease(KeyEvent.VK_NUMPAD2);
                    break;
                    case NUMPAD3:
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyRelease(KeyEvent.VK_NUMPAD3);
                    break;
                    case NUMPAD4:
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyRelease(KeyEvent.VK_NUMPAD4);
                    break;
                    case NUMPAD5:
                    robot.keyPress(KeyEvent.VK_NUMPAD5);
                    robot.keyRelease(KeyEvent.VK_NUMPAD5);
                    break;
                    case NUMPAD6:
                    robot.keyPress(KeyEvent.VK_NUMPAD6);
                    robot.keyRelease(KeyEvent.VK_NUMPAD6);
                    break;
                    case NUMPAD7:
                    robot.keyPress(KeyEvent.VK_NUMPAD7);
                    robot.keyRelease(KeyEvent.VK_NUMPAD7);
                    break;
                    case NUMPAD8:
                    robot.keyPress(KeyEvent.VK_NUMPAD8);
                    robot.keyRelease(KeyEvent.VK_NUMPAD8);
                    break;
                    case NUMPAD9:
                    robot.keyPress(KeyEvent.VK_NUMPAD9);
                    robot.keyRelease(KeyEvent.VK_NUMPAD9);
                    break;
                    case NUMPAD0:
                    robot.keyPress(KeyEvent.VK_NUMPAD0);
                    robot.keyRelease(KeyEvent.VK_NUMPAD0);
                    break;
                case BACK_SPACE:
                    robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                    break;
                case MULTIPLY:
                    robot.keyPress(KeyEvent.VK_MULTIPLY);
                    robot.keyRelease(KeyEvent.VK_MULTIPLY);
                    break;
                case ADD:
                    robot.keyPress(KeyEvent.VK_ADD);
                    robot.keyRelease(KeyEvent.VK_ADD);
                    break;
                case DIVIDE:
                    robot.keyPress(KeyEvent.VK_DIVIDE);
                    robot.keyRelease(KeyEvent.VK_DIVIDE);
                    break;
                case SUBTRACT:
                    robot.keyPress(KeyEvent.VK_SUBTRACT);
                    robot.keyRelease(KeyEvent.VK_SUBTRACT);
                    break;
                case ENTER:
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    break;
                // Add more cases as needed
                default:
                    throw new UnsupportedOperationException("Key not supported: " + key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
