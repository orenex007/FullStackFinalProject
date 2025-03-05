package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.sql.SQLException;

@Listeners(utilities.Listeners.class)
public class TestSwagLabsWebDB extends CommonOps {
    final String expectedLoginLogo = "Swag Labs";
    final String expectedHeaderAllPages = "Swag Labs";

    @Test(description = "Test01 - Verify Login To SwagLabs with DB Credentials")
    @Description("This Test login with DB credentials and verifies the main header")
    public void test01VerifyLoginDBHeader() throws SQLException {
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedLoginLogo);
        WebFlows.loginDB();
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsMainPage.allTitle, "Products");
        WebFlows.logout();
    }
    @Test(description = "Test02 - Verify Fill 'Your Information' in the SwagLabs with DB Credentials")
    @Description("This Test login with DB credentials and verifies the 'Your Information' Page")
    public void test02VerifyCheckoutDBHeader() throws SQLException {
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedLoginLogo);
        WebFlows.loginDB();
//      ========================== From Test01VerifyLoginDBHeader ==========================
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsMainPage.allTitle, "Products");
        WebFlows.logCart();
//      ========================== Move from Main page to Cart Page ==========================
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsCartPage.allTitle, "Your Cart");
        WebFlows.checkout();
//      ========================== Move from Cart page to Check Step One Page ==========================
        Verifications.verifyHeaderInAllPages(swagLabsCheckStepOnePage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsCheckStepOnePage.allTitle, "Checkout: Your Information");
        WebFlows.checkoutYourInformationDB();
        WebFlows.logout();
    }
}
