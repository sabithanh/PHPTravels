package net.phptravels.pageobjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends UserBasePage{

    public static final String PAY_NOW_BTN_CSS = "button.btn.btn-primary";
    @FindBy(css = PAY_NOW_BTN_CSS)
    WebElement btnPayNow;

    @FindBy(css = ".bg-white-shadow.col-12> .confirmation-list > li:nth-of-type(2) > .float-right.go-left")
    WebElement lblBookingNum;

    public WebElement getLblBookingNum() {
        return lblBookingNum;
    }

    public ConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getBtnPayNow() {
        wait.forPresenceOfElements(10, By.cssSelector(PAY_NOW_BTN_CSS), "Pay Now button");
        return btnPayNow;
    }
}
