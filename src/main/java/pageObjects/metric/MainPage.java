package pageObjects.metric;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    //Main Page
    @AndroidFindBy(xpath= "//*[@id='type_row_layout' and ./*[@text='Weight']]")
    public AndroidElement btn_row_layoutCurrency;

    //Weight Page
    @AndroidFindBy(id = "search")
    public AndroidElement txt_search;
    @AndroidFindBy(id = "unit_row_layout")
    public AndroidElement btn_row_layoutKilograms;
    @AndroidFindBy(xpath = "//*[@id='unit_row_text']")
    public AndroidElement btn_row_layoutPounds;

    //Convert Weight to Weight Page
    @AndroidFindBy(id = "question_and_answer_text")
    public AndroidElement textAnswer;
    @AndroidFindBy(id = "arg1")
    public AndroidElement txt_weight;

    @AndroidFindBy(id = "button_convert")
    public AndroidElement btn_convert;

}
