package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public void openLoginPage() {
        webDriver.get("http://client.roomizer.staging.thedevelopmentserver.com/#/login");
    }

    public boolean loginPageIsLoaded() {
        waitUntilElementIsAppear(usernameField);
        return webDriver.getCurrentUrl().equals("http://client.roomizer.staging.thedevelopmentserver.com/#/login");
    }

    public void login(String username, String password) {
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public MainPage clickOnSignInButton() {
        signInButton.click();
        return new MainPage(webDriver);
    }
}