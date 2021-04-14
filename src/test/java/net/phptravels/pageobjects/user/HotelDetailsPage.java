package net.phptravels.pageobjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelDetailsPage extends UserBasePage {

    public static final String CHECKBOX_SELECT_ROOM_CSS = ".room-item-wrapper .room-item .custom-checkbox label.custom-control-label";

    @FindBy(css = ".book_button")
    WebElement btnBookNow;

    @FindBy(css = CHECKBOX_SELECT_ROOM_CSS)
    List<WebElement> chkBoxSelectRooms;

    public HotelDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getBtnBookNow() {
        return btnBookNow;
    }

    public void clickBookNow(){
        btnBookNow.click();
    }

    public void selectRoom(){
        wait.forPresenceOfElements(5, By.cssSelector(CHECKBOX_SELECT_ROOM_CSS),"Select Room");
        chkBoxSelectRooms.get(0).click();
    }

}
