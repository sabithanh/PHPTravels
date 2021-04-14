package net.phptravels;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/HotelBooking.feature"},
        plugin = {"pretty",
                "json:target/cucumber_json_reports/hotel_booking.json",
                "html:target/hotel_booking-html"},
        glue = {"net.phptravels.driver",
                "net.phptravels.pageobjects",
                "net.phptravels.stepdefinitions"})

public class HotelBookingTest {
}


