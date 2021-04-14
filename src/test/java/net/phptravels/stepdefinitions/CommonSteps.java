package net.phptravels.stepdefinitions;

import io.cucumber.java.en.Given;
import net.phptravels.pageobjects.user.HomePage;
import net.phptravels.pageobjects.user.LoginPage;

public class CommonSteps {

    HomePage homePage;
    LoginPage loginPage;

    public CommonSteps() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Given("User logs into public website using {string} and {string}")
    public void userLogsIntoPublicWebsiteUsingAnd(String email, String password) {
        homePage.goToHomePage();
        homePage.clickMyAccountDropDown();
        homePage.clickFirstDropdown();
        loginPage.enterEmailAndPassword(email, password);
        loginPage.clickLogin();
    }
}
