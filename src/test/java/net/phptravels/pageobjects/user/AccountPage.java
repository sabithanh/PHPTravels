package net.phptravels.pageobjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage extends UserBasePage {

    public static final String TITLE_GREETING_CSS = ".main-wrapper .container div > h3";
    @FindBy(css = TITLE_GREETING_CSS)
    WebElement titleGreeting;

    @FindBy(css = ".sidebar-wrapper li:nth-of-type(2) > .nav-link")
    WebElement lnkMyProfile;

    @FindBy(css = ".mywishlist .tab-pane .main-wrapper .content-wrapper > h3")
    WebElement titleMyProfile;

    @FindBy(css = "input[name='address1']")
    WebElement inputAddress;

    @FindBy(css = "input[name='city']")
    WebElement inputCity;

    @FindBy(css = "input[name='zip']")
    WebElement inputZip;

    @FindBy(css = "input[name='phone']")
    WebElement inputPhoneNumber;

    @FindBy(css = ".btn.btn-block.btn-primary.updateprofile")
    WebElement btnSubmit;

    @FindBy(css = "#bookings > div > div.go-text-right > span")
    List<WebElement> bookingDetailsList;

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitleGreeting() {
        wait.forPresenceOfElements(5, By.cssSelector(TITLE_GREETING_CSS), "Page Title");
        return titleGreeting;
    }

    public List<WebElement> getBookingDetailsList() {
        return bookingDetailsList;
    }

    public WebElement getInputAddress() {
        return inputAddress;
    }

    public WebElement getInputCity() {
        return inputCity;
    }

    public WebElement getInputZip() {
        return inputZip;
    }

    public WebElement getInputPhoneNumber() {
        return inputPhoneNumber;
    }

    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    public WebElement getTitleMyProfile() {
        return titleMyProfile;
    }

    public void clickMyProfile() {
        lnkMyProfile.click();
        wait.forElementToBeDisplayed(5, titleMyProfile, "Profile Title");
    }

    public void updateAddress(String address) {
        inputAddress.clear();
        inputAddress.sendKeys(address);
    }

    public void updateCity(String city) {
        inputCity.clear();
        inputCity.sendKeys(city);
    }

    public void updateZip(String zip) {
        inputZip.clear();
        inputZip.sendKeys(zip);
    }

    public void updatePhone(String phone) {
        inputPhoneNumber.clear();
        inputPhoneNumber.sendKeys(phone);
    }

    public void clickSubmit() {
        btnSubmit.click();
        wait.forLoading(5);
    }
}
