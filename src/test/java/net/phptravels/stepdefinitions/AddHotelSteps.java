package net.phptravels.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.phptravels.pageobjects.admin.AddHotelsPage;
import net.phptravels.pageobjects.admin.HomePage;
import net.phptravels.pageobjects.admin.HotelsManagementPage;
import net.phptravels.pageobjects.admin.LoginPage;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class AddHotelSteps {
    final Logger log = Logger.getLogger(AccountSteps.class);

    private LoginPage loginPage;
    private HomePage homePage;
    private HotelsManagementPage hotelsManagementPage;
    private AddHotelsPage addHotelsPage;

    public AddHotelSteps() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        hotelsManagementPage = new HotelsManagementPage();
        addHotelsPage = new AddHotelsPage();
    }


    @Given("admin logs into CMS website using email {string} and password {string}")
    public void adminLogsIntoCMSWebsiteUsingEmailAndPassword(String email, String password) {
        loginPage.login(email,password);
    }

    @Then("the page should contain {string}")
    public void thePageShouldContain(String greeting) {
        Assert.assertEquals(greeting, homePage.getTitleGreeting().getText());
        log.info("Admin user has logged in successfully!");
    }

    @When("user clicks on Hotels menu and select Hotels submenu")
    public void userClicksOnHotelsMenuAndSelectHotelsSubmenu() {
        homePage.goToHotelsManagement();
    }

    @And("clicks on the Add button")
    public void clicksOnTheAddButton() {
        hotelsManagementPage.clickAddButton();
    }

    @Then("the page to add hotel details is opened")
    public void thePageToAddHotelDetailsIsOpened() {
        Assert.assertTrue(addHotelsPage.getBtnSubmit().isDisplayed());
    }

    @When("admin enters the following details in the general tab")
    public void adminEntersTheFollowingDetailsInTheGeneralTab() {
    }

    @And("enters the following details in the main settings")
    public void entersTheFollowingDetailsInTheMainSettings() {
    }

    @And("clicks on the facilities tab")
    public void clicksOnTheFacilitiesTab() {
    }

    @And("selects the following facilities")
    public void selectsTheFollowingFacilities() {
    }

    @And("clicks on the Translate tab")
    public void clicksOnTheTranslateTab() {
    }

    @And("enters the following details in translate tab")
    public void entersTheFollowingDetailsInTranslateTab() {
    }

    @And("clicks on the submit button")
    public void clicksOnTheSubmitButton() {
    }

    @Then("the hotels management page is loaded")
    public void theHotelsManagementPageIsLoaded() {
    }

    @And("the added hotel is displayed there")
    public void theAddedHotelIsDisplayedThere() {
    }


}
