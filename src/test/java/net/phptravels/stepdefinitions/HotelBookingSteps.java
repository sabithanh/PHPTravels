package net.phptravels.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.phptravels.pageobjects.user.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelBookingSteps {
    final Logger log = Logger.getLogger(AccountSteps.class);

    private final HomePage homePage;
    private final SearchResultPage searchResultPage;
    private final HotelDetailsPage hotelDetailsPage;
    private final PersonalDetailsPage personalDetailsPage;
    private final ConfirmationPage confirmationPage;
    private final AccountPage accountPage;

    private String bookingNumber;

    public HotelBookingSteps() {
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        hotelDetailsPage = new HotelDetailsPage();
        personalDetailsPage = new PersonalDetailsPage();
        confirmationPage = new ConfirmationPage();
        accountPage = new AccountPage();
    }

    @When("User searches using {string}, {string}, {string}")
    public void userSearchesUsing(String destination, String checkIn, String checkOut) {
        homePage.goToHomePage();
        homePage.enterDestination(destination);
        homePage.enterCheckInDate(checkIn);
        homePage.enterCheckOutDate(checkOut);
        homePage.clickAdultAdd();
        homePage.clickSearch();
    }

    @Then("Search result page is loaded with results")
    public void searchResultPageIsLoadedWithResults() {
        Assert.assertTrue(searchResultPage.getDivFilterBlock().isDisplayed());

        String totalNumListing = searchResultPage.getTxtTotalNumListing().getText();
        Assert.assertTrue(totalNumListing.contains("Total listings found"));

        int numOfHotels = Integer.parseInt(totalNumListing.replaceAll("\\D+", ""));
        Assert.assertEquals(numOfHotels, searchResultPage.getHotelList().size());
    }

//    @When("User filters using star grade and property type")
//    public void userFiltersUsingStarGradeAndPropertyType(DataTable table) {
//        List<Map<String, String>> list = table.asMaps(String.class, String.class);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).get("starGrade"));
//            System.out.println(list.get(i).get("propertyTypes"));
//        }
//    }

    @When("User filters using star grade {string} and property type {string}")
    public void userFiltersUsingStarGradeAndPropertyType(String starGrade, String propertyType) {
        searchResultPage.selectStarGrade(starGrade);
        searchResultPage.selectPropertyType(propertyType);
    }

    @Then("Result page is updated")
    public void resultPageIsUpdated() {
        searchResultPageIsLoadedWithResults();
    }

    @When("User clicks on a hotel details button")
    public void userClicksOnAHotelDetailsButton() {
        Assert.assertTrue(searchResultPage.getHotelList().size() > 0);
        WebElement element = searchResultPage.selectCheapestHotel();

        element.findElement(By.cssSelector(".content-bottom a.btn")).click();
    }

    @Then("Hotel details page is loaded")
    public void hotelDetailsPageIsLoaded() {
        Assert.assertTrue(hotelDetailsPage.getBtnBookNow().isDisplayed());
    }

    @When("User selects a room")
    public void userSelectsARoom() {
        hotelDetailsPage.selectRoom();
    }

    @And("Clicks book now button")
    public void clicksBookNowButton() {
        hotelDetailsPage.clickBookNow();
    }

    @Then("Personal details screen is loaded")
    public void personalDetailsScreenIsLoaded() {
        Assert.assertTrue(personalDetailsPage.getBtnConfirmBooking().isDisplayed());
    }

    @When("User clicks on confirm booking")
    public void userClicksOnConfirmBooking() {
        personalDetailsPage.clickConfirmBooking();
    }

    @Then("Confirmation screen is loaded")
    public void confirmationScreenIsLoaded() {
        Assert.assertTrue(confirmationPage.getBtnPayNow().isDisplayed());
        bookingNumber = confirmationPage.getLblBookingNum().getText();
    }

    @And("Selected hotel is found in bookings")
    public void selectedHotelIsFoundInBookings() {
        boolean found = false;
        for (WebElement it : accountPage.getBookingDetailsList()) {
            String text = it.getText();
            Assert.assertNotEquals("", text);
            Matcher matcher = Pattern.compile("Booking Number ([0-9]+)\\s+").matcher(text);
            if (matcher.find() && bookingNumber.equals(matcher.group(1))) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }


    @And("clicks on search button")
    public void clicksOnSearchButton() {
        searchResultPage.clickSearchButton();
    }

    @When("User clicks on Account link")
    public void userClicksOnAccountLink() {
        homePage.clickMyAccountDropDown();
    }

    @Then("Account page is opened")
    public void accountPageIsOpened() {
        homePage.clickFirstDropdown();
        Assert.assertTrue(accountPage.getTitleGreeting().isDisplayed());
    }
}
