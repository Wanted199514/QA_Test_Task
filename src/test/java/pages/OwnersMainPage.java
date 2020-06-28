package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersMainPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Expenses']")
    private WebElement expensesText;

    public OwnersMainPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean ownersMainPageIsLoaded() {
        waitUntilElementIsAppear(expensesText);
        return webDriver.getCurrentUrl().contains("http://owners.roomizer.staging.thedevelopmentserver.com/#/expenses");
    }
}
