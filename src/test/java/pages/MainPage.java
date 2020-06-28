package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//div/a[@title='Owners']")
    private WebElement ownersPage;

    public MainPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean mainPageIsLoaded() {
        waitUntilElementIsAppear(searchField);
        return webDriver.getCurrentUrl().contains("http://client.roomizer.staging.thedevelopmentserver.com/#/expenses");
    }

    public OwnersPage clickOnOwnersPage() {
        ownersPage.click();
        return new OwnersPage(webDriver);
    }
}
