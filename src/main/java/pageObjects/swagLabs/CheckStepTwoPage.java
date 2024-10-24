package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckStepTwoPage {
    @FindBy(className = "app_logo")
    private WebElement appLogoInAllPages;
    @FindBy(className = "title")
    public WebElement allTitle;
    @FindBy(name = "finish")
    public WebElement btn_finish;

    public WebElement getAppLogoInAllPages(){
        return appLogoInAllPages;
    }
}
