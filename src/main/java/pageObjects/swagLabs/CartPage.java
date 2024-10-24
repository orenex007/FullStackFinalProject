package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

    @FindBy(className = "app_logo")
    private WebElement appLogoInAllPages;
    @FindBy(className = "title")
    public WebElement allTitle;
    @FindBy(id = "reset_sidebar_link")
    public WebElement reset;
    @FindBy(className = "bm-burger-button")
    public WebElement btn_menu;
    @FindBy(id = "react-burger-cross-btn")
    public WebElement btn_menu_close;
    @FindBy(css = "button[class='btn btn_secondary back btn_medium'")
    public WebElement continueShoppingBackToMainPage;
    @FindBy(css = "button[class='btn btn_action btn_medium checkout_button '")
    public WebElement checkout;

    public WebElement getAppLogoInAllPages(){
        return appLogoInAllPages;
    }
}
