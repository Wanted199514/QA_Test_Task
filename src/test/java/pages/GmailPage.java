package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class GmailPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[2]/span/span[@name='Mike Mike']")
    private WebElement mikeMikeMail;

    @FindBy(xpath = "//a[text()='Click here']")
    private WebElement clickHereButton;

    public GmailPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean gmailPageIsLoaded() {
        waitUntilElementIsAppear(emailField);
        return webDriver.getCurrentUrl().contains("https://accounts.google.com/signin/");
    }

    public void login(String email, String password) {
        emailField.click();
        emailField.sendKeys(email);
        emailField.sendKeys(Keys.ENTER);
        waitUntilElementIsAppear(passwordField);
        passwordField.click();
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
    }

    public boolean mikeMikeMailIsLoaded() {
        waitUntilElementIsAppear(mikeMikeMail);
        return webDriver.getCurrentUrl().contains("https://mail.google.com/mail/");
    }

    public void goToURL() {
        mikeMikeMail.click();
        sleep(2000);
        clickHereButton.click();
    }

    public ChoosePasswordPage changeTab() {
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(1));
        return new ChoosePasswordPage(webDriver);
    }
}
