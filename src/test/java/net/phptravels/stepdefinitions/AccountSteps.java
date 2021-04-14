package net.phptravels.stepdefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.phptravels.pageobjects.user.AccountPage;
import net.phptravels.pageobjects.user.LoginPage;


public class AccountSteps {
    final Logger log = Logger.getLogger(AccountSteps.class);

    private LoginPage loginPage;
    private AccountPage accountPage;

    public AccountSteps() {
        loginPage = new LoginPage();
        accountPage = new AccountPage();
    }

    @Then("The page should contain {string}")
    public void thePageShouldContain(String greeting) {
        Assert.assertEquals(greeting, accountPage.getTitleGreeting().getText());
        log.info("User has logged in successfully!");
    }

    @When("User clicks on logout")
    public void userClicksOnLogout() {
        accountPage.clickLogout();
        log.info("User logged out successfully!");
    }

    @Then("User has logged out successfully")
    public void userHasLoggedOutSuccessfully() {
        loginPage.getBtnLogin().isEnabled();
    }

    @When("User clicks on My Profile link")
    public void userClicksOnMyProfileLink() {
        accountPage.clickMyProfile();
    }

    @Then("My Profile is opened")
    public void myProfileIsOpened() {
        Assert.assertTrue(accountPage.getTitleMyProfile().isDisplayed());
    }

    @When("User updates address as {string}")
    public void userUpdatesAddressAsAddress(String address) {
        accountPage.updateAddress(address);
    }

    @And("User updates city as {string}")
    public void userUpdatesCityAsCity(String city) {
        accountPage.updateCity(city);
    }

    @And("User updates postal code as {string}")
    public void userUpdatesPostalCodeAsZip(String postalCode) {
        accountPage.updateZip(postalCode);
    }

//    @And("User updates country as <string>")
//    public void userUpdatesCountryAs(String country) {
//        accountPage.update(country);
//    }

    @And("User updates phone number as {string}")
    public void userUpdatesPhoneNumberAsPhone(String phoneNumber) {
        accountPage.updatePhone(phoneNumber);
    }

    @And("User clicks on submit button")
    public void userClicksOnSubmitButton() {
        accountPage.clickSubmit();
    }

    @Then("The profile gets updated successfully with {string}, {string}, {string} and {string}")
    public void theProfileGetsUpdatedSuccessfullyWithAnd(String address, String city, String zip, String phone) {
//        waitForInvisibility(accountPage.getBtnSubmit());
//        getDriver().navigate().refresh();// to ensure updated values are saved
        accountPage.clickMyProfile();
        Assert.assertEquals(address, accountPage.getInputAddress().getAttribute("value"));
        Assert.assertEquals(city, accountPage.getInputCity().getAttribute("value"));
        Assert.assertEquals(zip, accountPage.getInputZip().getAttribute("value"));
        Assert.assertEquals(phone, accountPage.getInputPhoneNumber().getAttribute("value"));

    }
}
