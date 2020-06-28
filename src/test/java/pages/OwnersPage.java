package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersPage extends BasePage {

    @FindBy(xpath = "//span[text()='Create']")
    private WebElement createButton;

    public OwnersPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean ownersPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("http://client.roomizer.staging.thedevelopmentserver.com/#/owners");
    }

    public CreatePage clickOnCreateButton() {
        createButton.click();
        return new CreatePage(webDriver);
    }
}
