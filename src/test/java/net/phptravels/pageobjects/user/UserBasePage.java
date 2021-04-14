package net.phptravels.pageobjects.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.phptravels.pageobjects.BasePage;

public class UserBasePage extends BasePage {
    public final static String URL = "https://www.phptravels.net/";

    @FindBy(css = ".dropdown.dropdown-login.dropdown-tab > a.btn")
    WebElement dropDownMyAccount;

    @FindBy(css = ".dropdown-menu.dropdown-menu-right.show > div > a:nth-of-type(1)")
    WebElement dropDownFirst;

    @FindBy(css = ".dropdown-menu.dropdown-menu-right.show > div > a:nth-of-type(2)")
    WebElement dropdownSecond;

    @FindBy(css = "#mobileMenuMain > nav > ul:nth-child(1) > li > a")
    WebElement lnkHome;

    @FindBy(css = "#cookyGotItBtnBox > div > button")
    WebElement btnCookieConsent;

    @FindBy(id = "dropdownLangauge")
    WebElement dropdownLanguage;

    @FindBy(css = "a#en")
    WebElement lnkEnglish;

    public WebElement getLnkHome() {
        return lnkHome;
    }

    public void goToHomePage() {
        driver.get(URL);
        wait.forLoading(5);
        clickCookieConsent();
        selectEnglishLanguage();
    }

    public void selectHome() {
        lnkHome.click();
        wait.forLoading(5);
    }

    public void clickCookieConsent() {
        if (btnCookieConsent.isDisplayed()) {
            btnCookieConsent.click();
        }
    }

    public void selectEnglishLanguage() {
        if (dropdownLanguage.isDisplayed()) {
            if (dropdownLanguage.getText() != ("ENGLISH")){
                dropdownLanguage.click();
                lnkEnglish.click();
            }
        }
    }

    public void clickMyAccountDropDown() {
        dropDownMyAccount.click();
    }

    public void clickFirstDropdown() {
        dropDownFirst.click();
    }

    public void clickLogout() {
        dropDownMyAccount.click();
        dropdownSecond.click();
        wait.forLoading(5);
    }
}
