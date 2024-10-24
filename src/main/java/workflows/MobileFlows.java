package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {
    @Step("Business Flow: Enter Currency")
    public static void metricConversionsToWeight(){
        MobileActions.tap(metricMain.btn_row_layoutCurrency);
    }

    @Step("Business Flow: Find Weight Kilograms(KG) and Pounds(LBS)")
    public static void metricWeightKGAndLBS(String text){
        MobileActions.tap(metricMain.btn_row_layoutKilograms);
        MobileActions.updateText(metricMain.txt_search, text);
        MobileActions.tap(metricMain.btn_row_layoutPounds);

    }

    @Step("Business Flow: Convert Weight Kilograms(KG) to Pounds(LBS)")
    public static void convertWeight(String text){
        MobileActions.tap(metricMain.txt_weight);
        MobileActions.updateText(metricMain.txt_weight, text);
        MobileActions.tap(metricMain.btn_convert);
    }
}
