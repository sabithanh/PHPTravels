package net.phptravels.pageobjects.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends UserBasePage {
    @FindBy(css = "input[name='username']")
    WebElement txtEmail;

    @FindBy(css = "input[name='password']")
    WebElement txtPassword;

    @FindBy(css = "form#loginfrm > .btn.btn-block.btn-lg.btn-primary.loginbtn")
    WebElement btnLogin;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public void enterEmailAndPassword(String email, String password) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
        wait.forLoading(5);
    }
}
