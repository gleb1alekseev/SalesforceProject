package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest implements ITestConstants, IConstants {
    WebDriver driver;
    AccountPage accountPage;
    AccountListPage accountListPage;
    HomePage homePage;
    LoginPage loginPage;
    NewAccountModalPage newAccountModalPage;
    ContactPage contactPage;
    NewContactModalPage newContactModalPage;
    ContactListPage contactListPage;

    public void initPages(){
        accountPage = new AccountPage(driver);
        accountListPage = new AccountListPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        contactPage = new ContactPage(driver);
        newContactModalPage = new NewContactModalPage(driver);
        contactListPage = new ContactListPage(driver);
    }

    @BeforeMethod
    public  void initTest(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
        initPages();
    }

    @AfterMethod
    public void endTest(){
        driver.quit();
    }
}
