package net.phptravels.pageobjects;

import org.openqa.selenium.WebDriver;

import net.phptravels.driver.Setup;
import net.phptravels.driver.Wait;

public class BasePage {
    protected WebDriver driver;
    public Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}
