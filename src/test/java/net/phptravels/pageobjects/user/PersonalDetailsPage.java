package net.phptravels.pageobjects.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage extends UserBasePage{

    @FindBy(css = "button[name='logged']")
    WebElement btnConfirmBooking;

    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getBtnConfirmBooking() {
        return btnConfirmBooking;
    }

    public void clickConfirmBooking(){
        btnConfirmBooking.click();
    }
}
