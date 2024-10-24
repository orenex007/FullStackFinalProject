package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {
    final static String LinkedInExpected = "Sauce Labs | LinkedIn";
    final static String LinkedInSignUpExpected = "Sign Up | LinkedIn";
    final static String profileXExpected = "Profile / X";
    final static String sauceLabsXExpected = "sauceLabs";
    final static String XExpected = "X";
    final static String XNullExpected = "";

    //login and logout
    @Step("Business Flow: Login")
    public static void login(String user, String pass){
        UIActions.updateText(swagLabsLogin.txt_username, user);
        UIActions.updateText(swagLabsLogin.txt_password, pass);
        UIActions.click(swagLabsLogin.btn_login);
    }
    @Step("Business Flow: Logout")
    public static void logout(){
        UIActions.click(swagLabsLogin.btn_menu);
        UIActions.click(swagLabsLogin.btn_loginOut);
    }
    @Step("Business Flow: Login And Logout")
    public static void loginAndLogout(String user, String pass){
        login(user, pass);
        if (user.equals("locked_out_user")){
            UIActions.click(swagLabsLogin.btn_error);
            UIActions.deleteTextInTheInput(swagLabsLogin.txt_username);
            UIActions.deleteTextInTheInput(swagLabsLogin.txt_password);

        }
        else {
            logout();
        }
    }

    //Main Page

    @Step("Business Flow: Order By Z-A")
    public static void orderByZ_A(){
//        Select MyOrder = new Select(driver.findElement(By.className("product_sort_container")));
        Select MyOrder = new Select(swagLabsMainPage.productSort);
        MyOrder.selectByValue("za");
    }
    @Step("Business Flow: Order By Low-High")
    public static void orderByLow_High(){
//        String productSort = swagLabsMainPage.productSort;
//        Select MyOrder = new Select(driver.findElement(By.className("product_sort_container")));
        Select MyOrder = new Select(swagLabsMainPage.productSort);
        MyOrder.selectByValue("lohi");
    }
    @Step("Business Flow: Add Cart")
    public static void addCart(){
//        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']"));
        List<WebElement> addToCartButtons = swagLabsMainPage.btn_add_cart;
        for (WebElement button : addToCartButtons) {
            button.click();
        }
    }
    @Step("Business Flow: Add Four Carts")
    public static void addFourCarts() throws InterruptedException {
//        List<WebElement> addToFourCartButtons = driver.findElements(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']"));
        List<WebElement> addToFourCartButtons = swagLabsMainPage.btn_add_four_cart;
        if (addToFourCartButtons.size() >= 6){
            for (int i = 0; i < 4; i++){
                addToFourCartButtons.get(i).click();
            }
            Thread.sleep(1000);
        }
        else {
            System.out.println("There are less than 6 buttons on the page.");
        }
    }

    @Step("Business Flow: Remove Two Carts")
    public static void removeTwoCarts() throws InterruptedException {
        List<WebElement> removeToTwoCartButtons = swagLabsMainPage.btn_remove_cart;
        if (removeToTwoCartButtons.size() >= 4){
            for (int i = 0; i < 2; i++){
                removeToTwoCartButtons.get(i).click();
            }
            Thread.sleep(1000);
        }
        else {
            System.out.println("There are less than 4 buttons on the page.");
        }
    }

    @Step("Business Flow: Log Cart")
    public static void logCart(){
        UIActions.click(swagLabsMainPage.shopLogo);
    }

    //Cart Page
    @Step("Business Flow: Reset Cart")
    public static void resetCart(){
        UIActions.click(swagLabsCartPage.btn_menu);
        UIActions.click(swagLabsCartPage.reset);
        UIActions.click(swagLabsCartPage.btn_menu_close);
    }
    @Step("Business Flow: Continues Shopping Back")
    public static void continueShoppingBack(){
        UIActions.click(swagLabsCartPage.continueShoppingBackToMainPage);
    }
    @Step("Business Flow: Checkout")
    public static void checkout(){
        UIActions.click(swagLabsCartPage.checkout);
    }

    //Check Step One
    @Step("Business Flow: Fill Information")
    public static void fillInformation(String firstName, String lastName, String zipCode){
        UIActions.updateText(swagLabsCheckStepOnePage.txt_firstName, firstName);
        UIActions.updateText(swagLabsCheckStepOnePage.txt_lastName, lastName);
        UIActions.updateText(swagLabsCheckStepOnePage.txt_zipCode, zipCode);
        UIActions.click(swagLabsCheckStepOnePage.btn_continue);
    }

    //Check Step Two
    @Step("Business Flow: Payment")
    public static void payment(){
        UIActions.click(swagLabsCheckStepTwoPage.btn_finish);
    }
    //Check Out Complete
    @Step("Business Flow: Back Home")
    public static void backHome(){
        UIActions.click(swagLabsCheckoutCompletePage.btn_finish);
    }

//    ================== To Soical Media ==================

    @Step("Business Flow: Move To Twitter's Tab")
    public static void nextTabForTwitter(){
        UIActions.click(swagLabsMainPage.toSocialTwitter);
        String originalTab = UIActions.getCurrentTab();
        UIActions.getCurrentTab();
        //Move to new tab:
        UIActions.navigateToNewTab();
        String actualTitle = UIActions.getTitleFromWebsite();
        if (actualTitle.equals(profileXExpected)){
            Verifications.verifySocialMedia(actualTitle, profileXExpected);
        }
        else if (actualTitle.equals(sauceLabsXExpected)){
            Verifications.verifySocialMedia(actualTitle, sauceLabsXExpected);
        }
        else if (actualTitle.equals(XExpected)) {
            Verifications.verifySocialMedia(actualTitle, XExpected);
        }
        else{
            Verifications.verifySocialMedia(actualTitle, XNullExpected);
        }
//        Verifications.verifySocialMedia(actualTitle, "Profile / X");
        //Move back to original tab:
        UIActions.closeTab();
        UIActions.navigateToOriginal(originalTab);
    }

    @Step("Business Flow: Move To Facebook's Tab")
    public static void nextTabForFacebook(){
        UIActions.click(swagLabsMainPage.toSocialFacebook);
        String originalTab = UIActions.getCurrentTab();
        UIActions.getCurrentTab();
        //Move to new tab:
        UIActions.navigateToNewTab();
        UIActions.click(swagLabsMainPage.btn_close_facebook);
        String newTabText = UIActions.getTitleFromWebsite();
        Verifications.verifySocialMedia(newTabText, "Sauce Labs | Facebook");
        //Move back to original tab:
        UIActions.closeTab();
        UIActions.navigateToOriginal(originalTab);
    }

    @Step("Business Flow: Move To Linkedin's Tab")
    public static void nextTabForLinkedin(){
        UIActions.click(swagLabsMainPage.toSocialLinkedin);
        String originalTab = UIActions.getCurrentTab();
        UIActions.getCurrentTab();
        //Move to new tab:
        UIActions.navigateToNewTab();
        UIActions.actionKeysRETURN();
        String newTabText = UIActions.getTitleFromWebsite();
        String LinkedInSignUpOrNot = UIActions.getTitleFromWebsite();
        if (LinkedInSignUpOrNot.equals(LinkedInExpected)){
            Verifications.verifySocialMedia(newTabText, LinkedInExpected);
        }
        else{
            Verifications.verifyTextInLoginAndOut_AllImagesPresent(LinkedInSignUpOrNot, LinkedInSignUpExpected);
        }
        //Move back to original tab:
        UIActions.closeTab();
        UIActions.navigateToOriginal(originalTab);
    }
//        ================== Database ==================
    @Step("Business Flow: Login to SwagLabs with DB Credentials")
    public static void loginDB(){
        String query = "SELECT name, password FROM Employees WHERE id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(swagLabsLogin.txt_username, cred.get(0));
        UIActions.updateText(swagLabsLogin.txt_password, cred.get(1));
        UIActions.click(swagLabsLogin.btn_login);
    }


}