package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class TestMetricMobile extends CommonOps {
    final String textSearch = "Pounds";
    final String expectedTextWeight = "1kg= 2lb 3.273965oz";
    final int fillTextWeight = 70;
    final String expectedTextWeightAfterConvert = "70kg= 154lb 5.177536oz";

    @Test(description = "Test01 - Verify Check Weight")
    @Description("This Test Check Weight of KG and LBS")
    public void test01VerifyMetric() {
        MobileFlows.metricConversionsToWeight();
        MobileFlows.metricWeightKGAndLBS(textSearch);
        Verifications.expectWeightAnswer(metricMain.textAnswer, expectedTextWeight);
        MobileFlows.convertWeight(String.valueOf(fillTextWeight));
        Verifications.expectWeightAnswer(metricMain.textAnswer, expectedTextWeightAfterConvert);
        Verifications.verifyExpectationsALL();
//        mobileDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
