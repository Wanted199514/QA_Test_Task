package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage extends BasePage {

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//span[text()='Owner active']")
    private WebElement ownerActiveSwitch;

    @FindBy(xpath = "//span[text()='Send welcome Email']")
    private WebElement sendWelcomeEmailSwitch;

    @FindBy(xpath = "//div[@id='currency_id']")
    private WebElement currencyListBox;

    @FindBy(xpath = "//li[text()='EUR']")
    private WebElement eurCurrency;

    @FindBy(xpath = "//button[@aria-label='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@role='alert']/div")
    private WebElement alertMessage;

    @FindBy(xpath = "//input[@id='start_balance_date']")
    private WebElement startBalanceDateField;

    @FindBy(xpath = "//button[contains(@class,'current')]")
    private WebElement dateTodayButton;

    public CreatePage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean createPageIsLoaded() {
        waitUntilElementIsAppear(firstNameField);
        return webDriver.getCurrentUrl().contains("http://client.roomizer.staging.thedevelopmentserver.com/#/owners/create");
    }

    public void inputValidData(String firstName, String lastName, String email) {
        firstNameField.click();
        firstNameField.sendKeys(firstName);
        lastNameField.click();
        lastNameField.sendKeys(lastName);
        emailField.click();
        emailField.sendKeys(email);
        currencyListBox.click();
        eurCurrency.click();
        scrollDown();
        ownerActiveSwitch.click();
        sendWelcomeEmailSwitch.click();
        startBalanceDateField.click();
        dateTodayButton.click();
        saveButton.click();
    }

    public String alertIsLoaded() {
        waitUntilElementIsAppear(alertMessage);
        return alertMessage.getText();
    }

    public GmailPage openGmailPage() {
        webDriver.get("http://gmail.com/");
        return new GmailPage(webDriver);
    }
}
