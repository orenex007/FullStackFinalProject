package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;
    @FindBy(how = How.NAME, using = "Backspace")
    public WebElement btn_backspace;
    @FindBy(how = How.NAME, using = "One")
    public WebElement btn_one;
    @FindBy(how = How.NAME, using = "Two")
    public WebElement btn_two;

    @FindBy(how = How.NAME, using = "Three")
    public WebElement btn_three;
    @FindBy(how = How.NAME, using = "Four")
    public WebElement btn_four;
    @FindBy(name = "Five")
    public WebElement btn_five;
    @FindBy(name = "Six")
    public WebElement btn_six;
    @FindBy(name = "Seven")
    public WebElement btn_seven;
    @FindBy(name = "Eight")
    public WebElement btn_eight;
    @FindBy(name = "Nine")
    public WebElement btn_nine;
    @FindBy(name = "Zero")
    public WebElement btn_zero;
    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_plus;
    @FindBy(how = How.NAME, using = "Multiply by")
    public WebElement btn_multiply;
    @FindBy(name = "Minus")
    public WebElement btn_minus;
    @FindBy(name = "Divide by")
    public WebElement btn_divide;
    @FindBy(name = "Equals")
    public WebElement btn_equals;
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

}
