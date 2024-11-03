package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


@Listeners(utilities.Listeners.class)
public class TestCalculatorDesktop extends CommonOps {
final String anwser = "Display is ";
    @Test(description = "Test01 - Verify Addition And Multiplication Command")
    @Description("This Test Verifies The Addition Command")
    public void test01VerifyAdditionAndMultiplicationCommand(){
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElementWithSoft(calcMain.field_result, anwser + 8);
        DesktopFlows.calculateMultiplication();
        Verifications.verifyTextInElementWithSoft(calcMain.field_result, anwser + 32);
        Verifications.verifyExpectationsALL();
    }
    @Test(description = "Test02 - Verify Subtraction And Division Command")
    @Description("This Test Verifies The Subtraction And Division Command")
    public void test02VerifySubtractionAndDivisionCommand(){
        DesktopFlows.calculateSubtraction();
        Verifications.verifyTextInElementWithSoft(calcMain.field_result, anwser + -4);
        DesktopFlows.calculateDivision();
        Verifications.verifyTextInElementWithSoft(calcMain.field_result, anwser + 1.4);
        Verifications.verifyExpectationsALL();
    }
    @Test(description = "Test03 - Verify Cannot divide by zero")
    @Description("This Test Verifies The Cannot divide by zero")
    public void test03VerifySubtractionAndDivisionCommand(){
        DesktopFlows.calculateDivideByZero();
        Verifications.verifyTextInElement(calcMain.field_result, anwser + "Cannot divide by zero");
    }
}
