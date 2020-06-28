package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {
    private WebDriver webDriver;
    LoginPage loginPage;
    private ChromeOptions options = new ChromeOptions();

    @BeforeMethod
    protected void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\System32\\chromedriver.exe");
        webDriver = new ChromeDriver(options.addArguments("--disable-notifications"));
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
    }

    @AfterMethod
    protected void afterMethod() {
        webDriver.quit();
    }
}
