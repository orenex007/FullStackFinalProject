package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckStepOnePage {
    @FindBy(className = "app_logo")
    private WebElement appLogoInAllPages;
    @FindBy(className = "title")
    public WebElement allTitle;
    @FindBy(how = How.ID, using = "first-name")
    public WebElement txt_firstName;
    @FindBy(id = "last-name")
    public WebElement txt_lastName;
    @FindBy(id = "postal-code")
    public WebElement txt_zipCode;
    @FindBy(name = "continue")
    public WebElement btn_continue;

    public WebElement getAppLogoInAllPages(){
        return appLogoInAllPages;
    }
}
