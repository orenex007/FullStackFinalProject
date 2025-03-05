package sanity;

import extensions.MobileActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class TestMetricMobile extends CommonOps {
    final String textSearchWeight = "Pounds";
    final String expectedTextWeightKG = "1kg= 2lb 3.273965oz";
    final int fillTextWeightKG = 70;
    final String expectedTextWeightKGAfterConvert = "70kg= 154lb 5.177536oz";
    final String textSearchLength = "Feet";
    final String expectedTextLength = "1cm= 0ft 0.3937008in";
    final String expectedTextLengthWithDecimalAndFour = "1cm= 0.0328ft";
    final int fillTextLengthCM = 170;
    final String expectedLengthCentimeters = "170cm= 5.577ft";
    final String expectedLengthCentimetersFromOrigin = "170cm= 5ft 6.929134in";

    @Test(description = "Test01 - Verify Check Weight")
    @Description("This Test Check Weight of KG and LBS")
    public void test01VerifyMetricWeight() {
        MobileFlows.metricConversionsToWeight();
        MobileFlows.metricWeightKGAndLBS(textSearchWeight);
        Verifications.expectAnswer(metricMain.getTextAnswer(), expectedTextWeightKG);
        MobileFlows.convertWeight(String.valueOf(fillTextWeightKG));
        Verifications.expectAnswer(metricMain.getTextAnswer(), expectedTextWeightKGAfterConvert);
        MobileFlows.moveToHistory();
        Verifications.expectAnswer(metricMain.getHistory_row_text(), "Kilograms to Pounds");
        MobileFlows.DeleteAndBack();
        Verifications.verifyExpectationsALL();
    }
    @Test(description = "Test02 - Verify Check Length")
    @Description("This Test Check Length of CM and FEET")
    public void test02VerifyMetricLength() {
        MobileFlows.metricConversionsToLength();
        MobileFlows.metricLengthCMAndFEET(textSearchLength);
        Verifications.expectAnswer(metricMain.getTextAnswer(), expectedTextLength);
        MobileFlows.optionsForLength();
        Verifications.expectAnswer(metricMain.getTextAnswer(), expectedTextLengthWithDecimalAndFour);
        MobileFlows.convertLength(String.valueOf(fillTextLengthCM));
        Verifications.expectAnswer(metricMain.getTextAnswer(), expectedLengthCentimeters);
        MobileFlows.optionsForLengthToOrigin();
        Verifications.expectAnswer(metricMain.getTextAnswer(),expectedLengthCentimetersFromOrigin);
        MobileFlows.moveToHistory();
        Verifications.expectAnswer(metricMain.getHistory_row_text(), "Centimeters to Feet");
        MobileFlows.DeleteAndBack();
        Verifications.verifyExpectationsALL();
    }

}
