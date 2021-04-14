package net.phptravels.pageobjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends UserBasePage {

    @FindBy(css = ".select2-container.hotelsearch")
    WebElement selectDestination;

    @FindBy(css = "#checkin")
    WebElement inputCheckInDate;

    @FindBy(css = "#checkout")
    WebElement inputCheckOutDate;

    @FindBy(css = "#hotels form > div > div > div:nth-child(3) div > div.form-icon-left span > button.btn.btn-white.bootstrap-touchspin-up")
    WebElement btnAdultAdd;

    @FindBy(css = "#hotels > div > div > form > div > div > div > button[type=submit]")
    WebElement btnSearch;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterDestination(String value) {
        // click the select 2 wrapper
        selectDestination.click();
        String subContainerClass = "#select2-drop:not([style*='display: none'])";
        // get the hidden input and pass text
        WebElement selectInput = driver.findElement(By.cssSelector(subContainerClass + " .select2-input"));
        selectInput.clear();
        selectInput.sendKeys(value);
        By cssSelector = By.cssSelector(subContainerClass + " .select2-result.select2-result-selectable");
        wait.forPresenceOfElements(5, cssSelector, "select 2 dropdown");
        // get the first item from dropdown list and click
        WebElement selectedItem = driver.findElements(cssSelector).get(0);
        selectedItem.click();
    }

    public void enterCheckInDate(String value) {
        inputCheckInDate.clear();
        inputCheckInDate.sendKeys(value);
        closeCalenderPopup();
    }

    public void enterCheckOutDate(String value) {
        inputCheckOutDate.clear();
        inputCheckOutDate.sendKeys(value);
        closeCalenderPopup();
    }

    public void closeCalenderPopup() {
        // workaround due to UX bug, need to click somewhere else on the screen to close it since
        // click on buttons with events, like adult add, doesnt seem to close the calender popup
        driver.findElement(By.cssSelector("#airDatepickerRange-hotel div.form-icon-left > span")).click();
    }

    public void clickAdultAdd() {
        btnAdultAdd.click();
    }

    public void clickSearch() {
        btnSearch.click();
        wait.forLoading(10);
    }

}
