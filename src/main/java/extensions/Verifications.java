package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class Verifications extends CommonOps {

    @Step("Verify Text In Login And Logout All Images Present(Soft-Assertion)")
    public static void verifyTextInLoginAndOut_AllImagesPresent(String actual, String expected){
        soft.assertEquals(actual, expected);
        // Find all <img> elements on the page
        List<WebElement> images = driver.findElements(By.cssSelector("div[class='inventory_item_img']"));
        // Optionally, check each image has a valid source
        for (WebElement image : images) {
            String src = image.getAttribute("src");
            soft.assertTrue(image.isDisplayed(), "Image is not displayed: " + src);
            soft.assertTrue(image.getSize().getWidth() > 0 && image.getSize().getHeight() > 0, "Image has zero width or height: " + src);
        }
    }

//    @Step("Number Of Elements")
//    public static void numberOfElements(List<WebElement> elements, int expected){
//        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size() - 1 )));
//        Assert.assertEquals(elements.size(), expected);
//    }
    @Step("Visibility Of Elements")
    public static void visibilityOfElements(List<WebElement> elements){
        for (WebElement elem : elements){
            soft.assertTrue(elem.isDisplayed(), "Sorry " + elem.getText() + " not displayed");
        }
    }
//    @Step("expect Equals")
//    public static void expectEquals(int actual, int expected){
//        soft.assertEquals(actual,expected);
//    }


    @Step("Verify Logo Of Login")
    public static void verifyLogoLogin(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        soft.assertEquals(elem.getText(), expected);
    }
    @Step("Verify Header In All Pages")
    public static void verifyHeaderInAllPages(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        soft.assertEquals(elem.getText(), expected);
    }
    @Step("Verify All Title")
    public static void verifyAllTitle(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        soft.assertEquals(elem.getText(), expected);
    }
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed e) {
//            throw new RuntimeException(e);
            System.out.println("Error Comparing Image File: " + e);
            fail("Error Comparing Image File: " + e);
        }
    }

    @Step("Verify Social Media")
    public static void verifySocialMedia(String actualTitle, String expected){
        wait.until(ExpectedConditions.titleContains(driver.getTitle()));
//        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expected);
    }



    //======================== Verifications Mobile ========================
//    @Step("Verify Element Check Weight from KG to LBS")
//    public static void verifyWeightAnswer(WebElement elem, String expected){
//         Assert.assertEquals(elem.getText(), expected);
//    }

    @Step("Verify Element Check Weight from KG to LBS")
    public static void expectWeightAnswer(WebElement elem, String expected){
        soft.assertEquals(elem.getText(), expected);
    }
    //======================== Verifications SOFT ASSERT ALL INCLUDE WEB AND MOBILE ========================
    @Step("Verify Expectations(Soft-Assertion-Assert-All")
    public static void verifyExpectationsALL(){
        soft.assertAll();
    }

    //======================== Verifications API, Electron And Desktop ========================
    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected){
        assertEquals(actual, expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected){
        Assert.assertEquals(actual, expected);
    }

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(), expected);
    }


}
