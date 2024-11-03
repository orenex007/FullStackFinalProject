package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert soft;
    protected static Screen screen;
    protected static String platform;

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AndroidDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //Desktop
    protected static Robot robot;

    //Pages Objects - Web
    protected static pageObjects.swagLabs.LoginPage swagLabsLogin;
    protected static pageObjects.swagLabs.MainPage swagLabsMainPage;
    protected static pageObjects.swagLabs.CartPage swagLabsCartPage;
    protected static pageObjects.swagLabs.CheckStepOnePage swagLabsCheckStepOnePage;
    protected static pageObjects.swagLabs.CheckStepTwoPage swagLabsCheckStepTwoPage;
    protected static pageObjects.swagLabs.CheckoutCompletePage swagLabsCheckoutCompletePage;

    //Pages Objects - Mobile

    protected static pageObjects.metric.MainPage metricMain;

    //Pages Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;

    //Pages Objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;

}
