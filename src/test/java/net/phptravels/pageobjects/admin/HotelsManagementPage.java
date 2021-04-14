package net.phptravels.pageobjects.admin;

import net.phptravels.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsManagementPage extends BasePage {

    private static final String CSS_ADD_BUTTON = "form > .btn-success[type='submit']";

    @FindBy(css = CSS_ADD_BUTTON)
    WebElement btnAdd;

    public HotelsManagementPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton(){
        wait.forLoading(10);
        btnAdd.click();
    }
}
