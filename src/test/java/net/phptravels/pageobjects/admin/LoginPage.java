package net.phptravels.pageobjects.admin;

import net.phptravels.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public final static String URL = "https://www.phptravels.net/admin";

    @FindBy(css = "input[name='email'][type='text']")
    WebElement txtEmail;

    @FindBy(css = "input[name='password']")
    WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnLogin;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public WebElement getTxtEmail() {
        return txtEmail;
    }
    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public void goToHomePage() {
        driver.get(URL);
        wait.forLoading(5);
    }

    public void login(String email, String password){
        goToHomePage();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }
}
