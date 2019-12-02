package com.saucelabs.simplesauce.examples;

import com.saucelabs.simplesauce.SauceOptions;
import com.saucelabs.simplesauce.SauceSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverInitPattern {

    private WebDriver driver;
    private SauceSession sauce;

    /**
     * Use Simple Sauce here, in the Before hook
     */
    @Before
    public void setUp() {
        SauceOptions options = new SauceOptions();

        // Set options for Sauce Labs
        options.setBrowser(BrowserType.FIREFOX);
        options.setBrowserVersion("latest");

        // create a session and then use the driver in a typical way
        sauce = new SauceSession(options);
        driver = sauce.start();
    }

    /**
     * Use Sauce session only as related to Sauce functionality
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Encourage this pattern
     */
    @Test
    public void withPageObject(){
        MyPageObject page = new MyPageObject(driver);

        sauce.sendSauceLogging(driver, "Logging in");
        page.login();

        Assert.assertTrue(page.loginSuccessfully());

    }

    /**
     * Discourage this pattern
     */
    @Test
    public void withDriverDirectly() {
        driver.get("https://www.saucedemo.com");

        sauce.sendSauceLogging(driver, "Getting title");
        String actual = driver.getTitle();

        Assert.assertEquals(actual, "Swag Labs");
    }
}
