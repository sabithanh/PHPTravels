package net.phptravels.pageobjects.admin;

import net.phptravels.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public static final String CSS_TITLE_GREETING = "h2#mainHeader > strong";

    @FindBy(css = CSS_TITLE_GREETING)
    WebElement titleGreeting;

    @FindBy(css = "ul#social-sidebar-menu a[href='#Hotels']")
    WebElement menuHotels;

    @FindBy(css = "ul li>ul#Hotels > li:nth-child(1) > a")
    WebElement subMenuHotels;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLinkHotels() {
        return menuHotels;
    }
    public WebElement getSubMenuHotels() {
        return subMenuHotels;
    }

    public WebElement getTitleGreeting() {
        wait.forPresenceOfElements(5, By.cssSelector(CSS_TITLE_GREETING),"title greeting");
        return titleGreeting;
    }

    public void goToHotelsManagement(){
        menuHotels.click();
        subMenuHotels.click();
    }
}
