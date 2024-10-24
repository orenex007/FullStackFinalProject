package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage {
    @FindBy(className = "app_logo")
    private WebElement appLogoInAllPages;
    @FindBy(className = "title")
    public WebElement allTitle;
    @FindBy(css = "button[class='btn btn_primary btn_small']")
    public WebElement btn_finish;


    public WebElement getAppLogoInAllPages(){
        return appLogoInAllPages;
    }

}
