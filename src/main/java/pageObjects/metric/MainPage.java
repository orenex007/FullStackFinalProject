package pageObjects.metric;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {
    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }
    //########################## Elements ##########################

    //Main Page
    private By btn_row_layoutLength = By.xpath("//*[@id='type_row_layout' and ./*[@text='Length']]");
    private By btn_row_layoutWeight = By.xpath("//*[@id='type_row_layout' and ./*[@text='Weight']]");
    //Input Search
    private By txt_search = By.id("search");
    //Weight Page
    private By btn_FirstRow_layoutKilograms = By.id("unit_row_layout");
    private By btn_row_layoutPounds = By.xpath("//*[@id='unit_row_text']");
    // After 2 choices inputs
    private By textAnswer = By.id("question_and_answer_text");
    //Convert Page
    private By input_txt = By.id("arg1");
    private By btn_convert = By.id("button_convert");
    //Length Page
    private By btn_row_layoutCentimeters = By.xpath("//*[@id='unit_row_layout' and ./*[@text='Centimeters']]");
    private By btn_row_layoutFeet = By.xpath("//*[@id='unit_row_text']");
    //Buttons Of Options In The Convert Page
    private By btn_options_formatSpinner = By.id("format_spinner");
    private By btn_options_Decimal = By.xpath("//*[@text='Decimal']");
    private By btn_options_Defaulter = By.id("text1");
    private By btn_options_accuracy_spinner = By.id("accuracy_spinner");
    private By btn_options_fourSignificant = By.xpath("//*[@text='4 significant figures']");
    //History Page
    private By btn_bar_history = By.xpath("//*[@content-desc='History']");
    private By btn_bar_convert = By.xpath("//*[@contentDescription='Convert']");
    private By btn_delete = By.id("history_delete_button");
    private By history_row_text = By.id("history_row_text");

    //########################## Getters ##########################
    public AndroidElement getBtn_row_layoutLength(){
        return (AndroidElement) mobileDriver.findElement(btn_row_layoutLength);
    }
    public AndroidElement getBtn_row_layoutWeight(){
        return (AndroidElement) mobileDriver.findElement(btn_row_layoutWeight);
    }
    public AndroidElement getTxt_search(){
        return (AndroidElement) mobileDriver.findElement(txt_search);
    }
    public AndroidElement getBtn_FirstRow_layoutKilograms(){
        return (AndroidElement) mobileDriver.findElement(btn_FirstRow_layoutKilograms);
    }
    public AndroidElement getBtn_row_layoutPounds(){
        return (AndroidElement) mobileDriver.findElement(btn_row_layoutPounds);
    }
    public AndroidElement getTextAnswer(){
        return (AndroidElement) mobileDriver.findElement(textAnswer);
    }
    public AndroidElement getInput_txt(){
        return (AndroidElement) mobileDriver.findElement(input_txt);
    }
    public AndroidElement getBtn_convert(){
        return (AndroidElement) mobileDriver.findElement(btn_convert);
    }
    public AndroidElement getBtn_row_layoutCentimeters(){
        return (AndroidElement) mobileDriver.findElement(btn_row_layoutCentimeters);
    }
    public AndroidElement getBtn_row_layoutFeet(){
        return (AndroidElement) mobileDriver.findElement(btn_row_layoutFeet);
    }
    public AndroidElement getBtn_options_formatSpinner(){
        return (AndroidElement) mobileDriver.findElement(btn_options_formatSpinner);
    }
    public AndroidElement getBtn_options_Decimal(){
        return (AndroidElement) mobileDriver.findElement(btn_options_Decimal);
    }
    public AndroidElement getBtn_options_Defaulter(){
        return (AndroidElement) mobileDriver.findElement(btn_options_Defaulter);
    }
    public AndroidElement getBtn_options_accuracy_spinner(){
        return (AndroidElement) mobileDriver.findElement(btn_options_accuracy_spinner);
    }
    public AndroidElement getBtn_options_fourSignificant(){
        return (AndroidElement) mobileDriver.findElement(btn_options_fourSignificant);
    }
    public AndroidElement getBtn_bar_history(){
        return (AndroidElement) mobileDriver.findElement(btn_bar_history);
    }
    public AndroidElement getBtn_bar_convert(){
        return (AndroidElement) mobileDriver.findElement(btn_bar_convert);
    }
    public AndroidElement getBtn_delete(){
        return (AndroidElement) mobileDriver.findElement(btn_delete);
    }
    public AndroidElement getHistory_row_text(){
        return (AndroidElement) mobileDriver.findElement(history_row_text);
    }
}
