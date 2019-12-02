package com.saucelabs.simplesauce.examples;

import com.saucelabs.simplesauce.SauceOptions;
import com.saucelabs.simplesauce.SauceSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.BrowserType;

public class UseThroughoutPattern {

    private SauceSession sauce;

    /**
     * Initialize SauceSession here, and use throughout
     */
    @Before
    public void setUp() {
        SauceOptions options = new SauceOptions();

        // Set options for Sauce Labs
        options.setBrowser(BrowserType.CHROME);
        options.setBrowserVersion("latest");

        // create a session and then use the driver in a typical way
        sauce = new SauceSession(options);
        sauce.start();
    }

    /**
     * Use the built-in stop method
     */
    @After
    public void tearDown() {
        sauce.stop();
    }

    /**
     * Encourage tests that look like this
     */
    @Test
    public void withPageObject(){
        MyPageObject page = new MyPageObject(sauce.getWebDriver());

        sauce.sendSauceLogging("Logging in");
        page.login();

        Assert.assertTrue(page.loginSuccessfully());

    }

    /**
     * Discourage using tests like this
     */
    @Test
    public void withDriverDirectly() {
        sauce.getWebDriver().get("https://www.saucedemo.com");

        sauce.sendSauceLogging("Getting title");
        String actual = sauce.getWebDriver().getTitle();

        Assert.assertEquals(actual, "Swag Labs");
    }


}
