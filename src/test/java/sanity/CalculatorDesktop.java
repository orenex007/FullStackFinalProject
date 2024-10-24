package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {
    @Test(description = "Test01 - Verify Addition Command")
    @Description("This Test Verifies The Addition Command")
    public void test01VerifyAdditionCommand(){
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 9");
    }
}
