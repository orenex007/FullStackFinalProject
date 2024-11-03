package pageObjects.swagLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.ID, using = "user-name")
    public WebElement txt_username;
    @FindBy(name = "password")
    public WebElement txt_password;
    @FindBy(css = "input[type='submit']")
    public WebElement btn_login;
    @FindBy(className = "bm-burger-button")
    public WebElement btn_menu;
    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    public WebElement btn_loginOut;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    public WebElement actualLogin;
    @FindBy(className = "error-button")
    public WebElement btn_error;
    @FindBy(className = "login_logo")
    private WebElement loginLog;

    public WebElement getLoginLog(){
        return loginLog;
    }
}
