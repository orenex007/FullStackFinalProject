package pageObjects.metric;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {
    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    //Main Page
    @AndroidFindBy(xpath= "//*[@id='type_row_layout' and ./*[@text='Weight']]")
    public AndroidElement btn_row_layoutWeight;

    @AndroidFindBy(xpath= "//*[@id='type_row_layout' and ./*[@text='Length']]")
    public AndroidElement btn_row_layoutLength;

    //Input Search
    @AndroidFindBy(id = "search")
    public AndroidElement txt_search;

    //Weight Page
    @AndroidFindBy(id = "unit_row_layout")
    public AndroidElement btn_FirstRow_layoutKilograms;
    @AndroidFindBy(xpath = "//*[@id='unit_row_text']")
    public AndroidElement btn_row_layoutPounds;

    // After 2 choices inputs
    @AndroidFindBy(id = "question_and_answer_text")
    public AndroidElement textAnswer;

    //Convert Page
    @AndroidFindBy(id = "arg1")
    public AndroidElement input_txt;
    @AndroidFindBy(id = "button_convert")
    public AndroidElement btn_convert;

    //Length Page
    @AndroidFindBy(xpath= "//*[@id='unit_row_layout' and ./*[@text='Centimeters']]")
    public AndroidElement btn_row_layoutCentimeters;
    @AndroidFindBy(xpath = "//*[@id='unit_row_text']")
    public AndroidElement btn_row_layoutFeet;

    //Buttons Of Options In The Convert Page
    @AndroidFindBy(id= "format_spinner")
    public AndroidElement btn_options_formatSpinner;
    @AndroidFindBy(xpath= "//*[@text='Decimal']")
    public AndroidElement btn_options_Decimal;
    @AndroidFindBy(id = "text1")
    public AndroidElement btn_options_Defaulter;
    @AndroidFindBy(id= "accuracy_spinner")
    public AndroidElement btn_options_accuracy_spinner;
    @AndroidFindBy(xpath= "//*[@text='4 significant figures']")
    public AndroidElement btn_options_fourSignificant;

    //History Page
    @AndroidFindBy(xpath= "//*[@content-desc='History']")
    public AndroidElement btn_bar_history;
    @AndroidFindBy(xpath= "//*[@contentDescription='Convert']")
    public AndroidElement btn_bar_convert;
    @AndroidFindBy(id ="history_delete_button")
    public AndroidElement btn_delete;
    @AndroidFindBy(id = "history_row_text")
    public AndroidElement history_row_text;

}
