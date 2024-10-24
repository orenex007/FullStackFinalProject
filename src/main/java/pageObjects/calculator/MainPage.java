package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;
    @FindBy(how = How.NAME, using = "One")
    public WebElement btn_one;
    @FindBy(name = "Eight")
    public WebElement btn_eight;
    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_plus;
    @FindBy(name = "Equals")
    public WebElement btn_equals;
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;
}
