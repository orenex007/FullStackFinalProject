package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class TestSwagLabsWeb extends CommonOps {
    final String expectedGetLoginLogo = "Swag Labs";
    final String expectedHeaderAllPages = "Swag Labs";
    final String expectedSuccess = "";
    final String expectedLockedOut = "Epic sadface: Sorry, this user has been locked out.";
    final String expectedError = "Epic sadface: Username and password do not match any user in this service";
    final String USERNAME = getData("UserName");
    final String PASSWORD = getData("Password");
    final String FIRSTNAME = "Oren";
    final String LASTNAME = "Abarbanel";
    final String ZIPCODE = "123";

    @Test(description = "Test01 - Verify Check Add And Cancel")
    @Description("This Test Add All Carts And Cancel All Carts")
    public void test01VerifyCheckAddAndCancel(){
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedGetLoginLogo);
        WebFlows.login(USERNAME, PASSWORD);
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsMainPage.allTitle, "Products");
        WebFlows.orderByZ_A();
        WebFlows.addCart();
//        =====================Move from Main page to Cart Page=====================
        WebFlows.logCart();
        Verifications.verifyHeaderInAllPages(swagLabsCartPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsCartPage.allTitle, "Your Cart");
        WebFlows.resetCart();
        WebFlows.continueShoppingBack();
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsMainPage.allTitle, "Products");
        Verifications.verifyExpectationsALL();
        WebFlows.logout();
    }

    @Test(description = "Test02 - Verify Check Buying")
    @Description("This Test Add && Remove A Few Carts And Buy")
    public void test02VerifyCheckAddAndBuy() throws InterruptedException {
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedGetLoginLogo);
        WebFlows.login(USERNAME, PASSWORD);
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsMainPage.allTitle, "Products");
        WebFlows.orderByLow_High();
        WebFlows.addFourCarts();
//        =====================Move from Main page to Cart Page=====================
        WebFlows.logCart();
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsCartPage.allTitle, "Your Cart");
        WebFlows.removeTwoCarts();
        WebFlows.checkout();
//        =====================Move from Cart page to Check Step One Page=====================
        Verifications.verifyHeaderInAllPages(swagLabsCheckStepOnePage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsCheckStepOnePage.allTitle, "Checkout: Your Information");
        WebFlows.fillInformation(FIRSTNAME, LASTNAME, ZIPCODE);
//        =====================Move from Check Step One Page to Check Step Two Page=====================
        Verifications.verifyHeaderInAllPages(swagLabsCheckStepTwoPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsCheckStepTwoPage.allTitle, "Checkout: Overview");
        WebFlows.payment();
//        =====================Move from Check Step Two Page to Check Out Complete Page=====================
        Verifications.verifyHeaderInAllPages(swagLabsCheckoutCompletePage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsCheckoutCompletePage.allTitle, "Checkout: Complete!");
        Verifications.visualElement("GreenIconChecked");
        WebFlows.backHome();
//        =====================Move from Check Out Complete Page to Main Page=====================
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsMainPage.allTitle, "Products");
        Verifications.verifyExpectationsALL();
        WebFlows.logout();
    }

    @Test(description = "Test03 - Verify About Saucelabs")
    @Description("This Test Enter Login And Move From Main Page To About Page, Then Back To Main Page")
    public void test03VerifyAbout(){
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedGetLoginLogo);
        WebFlows.login("visual_user", PASSWORD);
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        UIActions.click(swagLabsMainPage.btn_menu);
        UIActions.mouseHover(swagLabsMainPage.aboutAllItems, swagLabsMainPage.aboutResetAppState, swagLabsMainPage.aboutLogout, swagLabsMainPage.about);
//        WebFlows.menuToAbout();
        Verifications.verifyExpectationsALL();
        UIActions.navigateBackInWindow();
        WebFlows.logout();
    }
    @Test(description = "Test04 - Verify Enter All Social Media")
    @Description("This Test Enter All Social Media from Swag Labs Website")
    public void test04VerifySocialMedia(){
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedGetLoginLogo);
        WebFlows.login("error_user", PASSWORD);
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        UIActions.scrollDown();
        WebFlows.nextTabForTwitter();
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        UIActions.scrollDown();
        WebFlows.nextTabForFacebook();
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        UIActions.scrollDown();
        WebFlows.nextTabForLinkedin();
        Verifications.verifyExpectationsALL();
    }

    @Test(description = "Test05 - Verify Use All Usernames For Login", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test All Usernames Login In A LoginPage")
    public void test05VerifyCheckLogin(String user, String pass){
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedGetLoginLogo);
        WebFlows.loginAndLogout(user, pass);
        String actualLogin = swagLabsLogin.actualLogin.getText();
        if (actualLogin.equals(expectedLockedOut)){
            Verifications.verifyTextInLoginAndOut_AllImagesPresent(actualLogin, expectedLockedOut);
        }
        else if (actualLogin.equals(expectedSuccess)){
            Verifications.verifyTextInLoginAndOut_AllImagesPresent(actualLogin, expectedSuccess);
        }
        else {
            Verifications.verifyTextInLoginAndOut_AllImagesPresent(actualLogin, expectedError);
        }
        Verifications.visibilityOfElements(swagLabsMainPage.listInventory);
        Verifications.verifyExpectationsALL();
    }
}
