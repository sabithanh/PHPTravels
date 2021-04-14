package net.phptravels;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Account.feature"},
        plugin = {"pretty",
                "json:target/cucumber_json_reports/account.json",
                "html:target/account-html"},
        glue = {"net.phptravels.driver",
                "net.phptravels.pageobjects",
                "net.phptravels.stepdefinitions"})

public class AccountTest {
}


