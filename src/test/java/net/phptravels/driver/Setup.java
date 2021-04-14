package net.phptravels.driver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() {

        String browser = System.getProperty("browser");

        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                if (System.getProperty("webdriver.chrome.driver").equals("")) {
                    Assert.fail("Chrome webdriver path is not set. Please set 'webdriver.chrome.driver' value");
                }
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "firefox":
                if (System.getProperty("webdriver.gecko.driver").equals("")) {
                    Assert.fail("Firefox webdriver path is not set. Please set 'webdriver.gecko.driver' value");
                }
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
}
