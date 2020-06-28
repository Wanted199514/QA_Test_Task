package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver webDriver;

    public void initializationWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    protected void waitUntilElementIsAppear(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver,20);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void scrollDown() {
        ((JavascriptExecutor)webDriver).executeScript("scroll(0,10000)");
    }
}
