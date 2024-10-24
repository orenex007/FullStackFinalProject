package utilities;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;


public class ManagePages extends Base {
    public static void initSwagLabs(){
        swagLabsLogin = PageFactory.initElements(driver, pageObjects.swagLabs.LoginPage.class);
        swagLabsMainPage = PageFactory.initElements(driver, pageObjects.swagLabs.MainPage.class);
        swagLabsCartPage = PageFactory.initElements(driver, pageObjects.swagLabs.CartPage.class);
        swagLabsCheckStepOnePage = PageFactory.initElements(driver, pageObjects.swagLabs.CheckStepOnePage.class);
        swagLabsCheckStepTwoPage = PageFactory.initElements(driver, pageObjects.swagLabs.CheckStepTwoPage.class);
        swagLabsCheckoutCompletePage = PageFactory.initElements(driver, pageObjects.swagLabs.CheckoutCompletePage.class);
    }

    public static void initMetric(){
//        metricMain = PageFactory.initElements(mobileDriver, pageObjects.metric.MainPage.class);
        metricMain = new pageObjects.metric.MainPage(mobileDriver);
    }

    public static void initToDo(){
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
