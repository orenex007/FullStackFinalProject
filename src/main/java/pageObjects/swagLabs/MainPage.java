package pageObjects.swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Base;

import java.util.List;

public class MainPage{
    @FindBy(className = "app_logo")
    private WebElement appLogoInAllPages;
    @FindBy(className = "title")
    public WebElement allTitle;
    @FindBy(id = "shopping_cart_container")
    public WebElement shopLogo;
//    @FindBy(id = "reset_sidebar_link")
//    public WebElement reset;
//    @FindBy(css = "button[class='btn btn_secondary back btn_medium'")
//    public WebElement continueShoppingBackToMainPage;
    @FindBy(css = "div[data-test='inventory-list']")
    public List<WebElement> listInventory;

    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory ']")
    public List<WebElement> btn_add_cart;

    @FindBy(className = "pricebar")
    public List<WebElement> btn_add_four_cart;
//   xpath *[@class="btn btn_primary btn_small btn_inventory "]
//    cssSelector "button[class='btn btn_primary btn_small btn_inventory ']"
    @FindBy(className = "product_sort_container")
    public WebElement productSort;

    @FindBy(css = "button[class='btn btn_secondary btn_small cart_button']")
    public List<WebElement> btn_remove_cart;




//    ================== To About ==================
    @FindBy(className = "bm-burger-button")
    public WebElement btn_menu;
    @FindBy(css = "a[data-test='inventory-sidebar-link']")
    public WebElement aboutAllItems;
    @FindBy(css = "a[data-test='about-sidebar-link']")
    public WebElement about;
    @FindBy(css = "a[data-test='logout-sidebar-link']")
    public WebElement aboutLogout;
    @FindBy(css = "a[data-test='logout-sidebar-link']")
    public WebElement aboutResetAppState;

////    ================== In About Website==================
//    @FindBy(css = "div[class='MuiBox-root css-lwb5go']")
//    public WebElement logoAbout;

//    ================== To Social Media From Swag Labs==================
    @FindBy(css = "a[data-test='social-twitter']")
    public WebElement toSocialTwitter;
    @FindBy(css = "a[data-test='social-facebook']")
    public WebElement toSocialFacebook;
    @FindBy(css ="div[class='x92rtbv x10l6tqk x1tk7jg1 x1vjfegm']")
    public WebElement btn_close_facebook;

    @FindBy(css = "a[data-test='social-linkedin']")
    public WebElement toSocialLinkedin;

    @FindBy(xpath = "/html/body/div[3]/div/div/section/button/icon/svg")
    public WebElement btn_close_linkedin;
    
    public WebElement getAppLogoInAllPages(){
        return appLogoInAllPages;
    }

}
