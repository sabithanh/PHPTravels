package net.phptravels;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/AddHotel.feature"},
        plugin = {"pretty",
                "json:target/cucumber_json_reports/add_hotel.json",
                "html:target/add_hotel-html"},
        glue = {"net.phptravels.driver",
                "net.phptravels.pageobjects",
                "net.phptravels.stepdefinitions"})

public class AddHotelTest {
}


