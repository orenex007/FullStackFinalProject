package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;
import workflows.WebFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {
    //function
    /*
    #############################################################################
    Method Name: getData
    Method Description: This Method get the data from xml configuration file
    Method Parameters: String
    Method Return: String
    #############################################################################
    */
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            driver = initSafariDriver();
        } else if (browserType.equalsIgnoreCase("opera")) {
            driver = initOperaDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = initEdgeDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            driver = initIEDriver();
        } else {
            throw new RuntimeException("Invalid Browser Type");
        }
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("URL"));
        ManagePages.initSwagLabs();
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initSafariDriver() {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        return driver;
    }

    public static WebDriver initOperaDriver() {
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Can not connect to appium server, see details: " + e);
        }
        ManagePages.initMetric();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
//        action = new Actions(driver);
    }

    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
//        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");
    }
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }

    public static void initDesktop(){
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }
        try {
            robot = new Robot();
        } catch (AWTException e) {
//            throw new RuntimeException(e);
            System.out.println("Can not Connect to Appium Server, See Details: " + e);

        }
        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
//        String platform = PlatformName; //from first class from ATIDCOLLEGE
//        if (platform.equalsIgnoreCase("web")) {} before charge String from getData("platformName"))
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web")) {
            initBrowser(getData("BrowserName"));
            action = new Actions(driver);
        } else if (platform.equalsIgnoreCase("mobile")) {
            initMobile();
            action = new Actions(mobileDriver);
        } else if (platform.equalsIgnoreCase("api")) {
            initAPI();
        } else if (platform.equalsIgnoreCase("electron")) {
            initElectron();
            action = new Actions(driver);
        } else if (platform.equalsIgnoreCase("desktop")) {
            initDesktop();
        } else {
            throw new RuntimeException("Invalid platformName");
        }
        soft = new SoftAssert();
        screen = new Screen();
//        action = new Actions(driver);
        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("mobile")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
//            throw new RuntimeException(e);
                e.printStackTrace();
            }

        }
    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web")) {
            driver.get(getData("URL"));
        }
        else if (platform.equalsIgnoreCase("electron")) {
            ElectronFlows.emptyList();
        }
    }

    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile")) {
                driver.quit();
            } else {
                mobileDriver.quit();
            }
        }
    }

//    @AfterClass
//    public void closeSession2(){
//        if (!platform("platformName").equalsIgnoreCase("api") ||
//                !platform("platformName").equalsIgnoreCase("mobile")){
//            driver.quit();
//        }
//        else {
//            mobileDriver.quit();
//        }
//    }

    @Test
    public void test1() {
    }
}

