package net.phptravels.driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Wait {

    private final WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forLoading(int timeoutSecs) {
        forLoading(timeoutSecs / 2, timeoutSecs / 2);
    }

    public void forLoading(int timeoutSecs, int sleepTimeoutSecs) {
        ExpectedCondition<Object> expectation = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "Page didn't load after " + timeoutSecs + " seconds.";
        try {
            // ideally this shouldn't be needed, but PHP travels seems to take some time to actually render elements after page ready
            Thread.sleep(sleepTimeoutSecs * 1000L);
            waitUntilCondition(expectation, timeoutMessage, timeoutSecs);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void forElementToBeDisplayed(int timeout, WebElement webElement, String webElementName) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forPresenceOfElements(int timeout, By elementLocator, String elementName) {
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = elementName + " elements were not displayed after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }
}