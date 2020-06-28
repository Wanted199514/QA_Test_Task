package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChoosePasswordPage extends BasePage {

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    public ChoosePasswordPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean choosePasswordPageIsLoaded() {
        waitUntilElementIsAppear(passwordField);
        return webDriver.getCurrentUrl().contains("http://owners.roomizer.staging.thedevelopmentserver.com/#/choose-password?");
    }

    public OwnersLoginPage createPassword(String password, String confirmPassword) {
        passwordField.click();
        passwordField.sendKeys(password);
        confirmPasswordField.click();
        confirmPasswordField.sendKeys(confirmPassword);
        saveButton.click();
        return new OwnersLoginPage(webDriver);
    }
}
