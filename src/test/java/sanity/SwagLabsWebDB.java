package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SwagLabsWebDB extends CommonOps {
    final String expectedgetLoginLogo = "Swag Labs";
    final String expectedHeaderAllPages = "Swag Labs";

    @Test(description = "Test01 - Verify Login To SwagLabs with DB Credentials")
    @Description("This Test login with DB credentials and verifies the main header")
    public void test01VerifyLoginDBHeader(){
        Verifications.verifyLogoLogin(swagLabsLogin.getLoginLog(), expectedgetLoginLogo);
        WebFlows.loginDB();
        Verifications.verifyHeaderInAllPages(swagLabsMainPage.getAppLogoInAllPages(), expectedHeaderAllPages);
        Verifications.verifyAllTitle(swagLabsMainPage.allTitle, "Products");
    }
}
