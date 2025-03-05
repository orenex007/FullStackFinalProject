package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    // ====================== Weight ======================
    @Step("Business Flow: Enter Weight")
    public static void metricConversionsToWeight(){
        MobileActions.tap(metricMain.getBtn_row_layoutWeight());
    }

    @Step("Business Flow: Find Weight Kilograms(KG) And Pounds(LBS)")
    public static void metricWeightKGAndLBS(String text){
        MobileActions.tap(metricMain.getBtn_FirstRow_layoutKilograms());
        MobileActions.updateText(metricMain.getTxt_search(), text);
        MobileActions.tap(metricMain.getBtn_row_layoutPounds());

    }

    @Step("Business Flow: Convert Weight Kilograms(KG) To Pounds(LBS)")
    public static void convertWeight(String text){
        MobileActions.tap(metricMain.getInput_txt());
        MobileActions.updateText(metricMain.getInput_txt(), text);
        MobileActions.tap(metricMain.getBtn_convert());
    }
    @Step("Business Flow: Android Key Back Three Times")
    public static void backThreeTimes(){
        MobileActions.androidKeyBack();
        MobileActions.androidKeyBack();
        MobileActions.androidKeyBack();
    }

    @Step("Business Flow: Delete and Enter to Convert Back")
    public static void DeleteAndBack(){
        MobileActions.tap(metricMain.getBtn_delete());
        MobileActions.tap(metricMain.getBtn_bar_convert());
    }
    @Step("Business Flow: Enter To History")
    public static void moveToHistory(){
        MobileActions.tap(metricMain.getBtn_bar_history());
    }

    // ====================== Length ======================
    @Step("Business Flow: Enter Length")
    public static void metricConversionsToLength(){
        MobileActions.tap(metricMain.getBtn_row_layoutLength());
    }

    @Step("Business Flow: Find Length Centimeters(CM) And Feet")
    public static void metricLengthCMAndFEET(String text){
        MobileActions.tap(metricMain.getBtn_row_layoutCentimeters());
        MobileActions.updateText(metricMain.getTxt_search(), text);
        MobileActions.tap(metricMain.getBtn_row_layoutFeet());

    }

    @Step("Business Flow: Convert Length Centimeters(CM) To Feet")
    public static void convertLength(String text){
        MobileActions.tap(metricMain.getInput_txt());
        MobileActions.updateText(metricMain.getInput_txt(), text);
        MobileActions.tap(metricMain.getBtn_convert());
    }

    @Step("Business Flow: Change Options To Decimal And Four Significant Figures")
    public static void optionsForLength(){
        MobileActions.tap(metricMain.getBtn_options_formatSpinner());
        MobileActions.tap(metricMain.getBtn_options_Decimal());
        MobileActions.tap(metricMain.getBtn_options_accuracy_spinner());
        MobileActions.tap(metricMain.getBtn_options_fourSignificant());
    }

    @Step("Business Flow: Change Options Back")
    public static void optionsForLengthToOrigin(){
        MobileActions.tap(metricMain.getBtn_options_formatSpinner());
        MobileActions.tap(metricMain.getBtn_options_Defaulter());
        MobileActions.tap(metricMain.getBtn_options_accuracy_spinner());
        MobileActions.tap(metricMain.getBtn_options_Defaulter());
    }

}
