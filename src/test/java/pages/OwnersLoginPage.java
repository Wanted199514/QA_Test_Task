package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersLoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@role='alert']/div")
    private WebElement alertMessage;

    public OwnersLoginPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean ownersLoginPageIsLoaded() {
        waitUntilElementIsAppear(usernameField);
        return webDriver.getCurrentUrl().equals("http://owners.roomizer.staging.thedevelopmentserver.com/#/login");
    }

    public void login(String username, String password) {
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public OwnersMainPage clickOnSignInButton() {
        signInButton.click();
        return new OwnersMainPage(webDriver);
    }


    public String alertIsLoaded() {
        waitUntilElementIsAppear(alertMessage);
        return alertMessage.getText();
    }
}
