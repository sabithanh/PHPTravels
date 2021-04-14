package net.phptravels.pageobjects.admin;

import net.phptravels.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddHotelsPage extends BasePage {

    @FindBy(css = "button.btn-primary#add")
    WebElement btnSubmit;

    @FindBy(css = ".panel .col-md-12 input[name='hotelname']")
    WebElement txtHotelName;

//    @FindBy(css = "button.btn-primary#add")
//    WebElement txtDescription;

    @FindBy(css = "#cke_1_contents iframe")
    WebElement descriptionIFrame;

    @FindBy(css = "button.btn-primary#add")
    WebElement txtStars;

    @FindBy(css = "button.btn-primary#add")
    WebElement dropDownItemHotelType;

    @FindBy(css = "button.btn-primary#add")
    WebElement txtLocation;

    public AddHotelsPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getBtnSubmit() {
        wait.forLoading(300, 2);
        return btnSubmit;
    }

    public WebElement getDescriptionBody(){
        return descriptionIFrame.findElement(By.cssSelector("body"));
    }
}
