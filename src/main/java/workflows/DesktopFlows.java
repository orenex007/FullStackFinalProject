package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {
    @Step("Business Flow: Calculate Addition 2 + 6")
    public static void calculateAddition(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_six);
        UIActions.click(calcMain.btn_equals);
    }
    @Step("Business Flow: Calculate Addition 8 X 4")
    public static void calculateMultiplication(){
        UIActions.click(calcMain.btn_clear);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD8);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD1);
        UIActions.insertKeyWithoutWebElement(Keys.BACK_SPACE);
        UIActions.insertKeyWithoutWebElement(Keys.MULTIPLY);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD4);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD7);
        UIActions.insertKeyWithoutWebElement(Keys.BACK_SPACE);
        UIActions.insertKeyWithoutWebElement(Keys.ENTER);
    }

    @Step("Business Flow: Calculate Addition 3 - 9")
    public static void calculateSubtraction(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_three);
        UIActions.click(calcMain.btn_minus);
        UIActions.click(calcMain.btn_seven);
        UIActions.click(calcMain.btn_equals);
    }
    @Step("Business Flow: Calculate Addition 7 / 5")
    public static void calculateDivision(){
        UIActions.click(calcMain.btn_clear);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD7);
        UIActions.insertKeyWithoutWebElement(Keys.DIVIDE);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD5);
        UIActions.insertKeyWithoutWebElement(Keys.ENTER);
    }
    @Step("Business Flow: Calculate Cannot divide by zero")
    public static void calculateDivideByZero(){
        UIActions.click(calcMain.btn_clear);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD1);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD2);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD3);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD4);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD5);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD6);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD7);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD8);
        UIActions.insertKeyWithoutWebElement(Keys.NUMPAD9);
        UIActions.insertKeyWithoutWebElement(Keys.DIVIDE);
        UIActions.click(calcMain.btn_zero);
        UIActions.click(calcMain.btn_equals);
    }
}
