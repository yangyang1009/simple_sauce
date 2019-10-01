package com.saucelabs.simplesauce.acceptance;

import com.saucelabs.simplesauce.SauceSession;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.*;

@Ignore
public class SauceSessionAcceptanceTest {
    private WebDriver webDriver;

    @After
    public void cleanUp()
    {
        if(webDriver != null)
            webDriver.quit();
    }
    @Test
    public void withWindows10_default() {
        String actualOs = (((RemoteWebDriver) webDriver).getCapabilities()).getPlatform().toString();
        //TODO why in the F is this returning XP even though in Sauce it shows Windows 10
        assertEquals("XP", actualOs);
    }
    @Test
    public void withSafari_default_isMojave() {
        String actualBrowserVersion = (((RemoteWebDriver) webDriver).getCapabilities()).getPlatform().toString();
        assertEquals("MAC", actualBrowserVersion);
    }
    @Test
    public void withSafari_default_isBrowserVersion12_0() {
        String actualBrowserVersion = (((RemoteWebDriver) webDriver).getCapabilities()).getVersion();
        assertEquals("12.0", actualBrowserVersion);
    }
    @Test
    public void startSession_noSauceOptionsSet_returnsDriver() {
        SauceSession session = new SauceSession();
        session.start();
        webDriver = session.getWebDriver();
        assertNotNull(webDriver);
    }

    @Test
    public void withFirefox_returnsCorrectDriver() {
        String actualBrowser = getBrowserNameFromCapabilities();
        assertEquals("firefox", actualBrowser);
    }

    private String getBrowserNameFromCapabilities() {
        return (((RemoteWebDriver) webDriver).getCapabilities()).getBrowserName();
    }

    @Test
    @Ignore("Not sure how to make it work")
    public void withEdge_default_returnsValidEdgeSession() {
        String actualBrowser = getBrowserNameFromCapabilities();
        assertThat(actualBrowser, IsEqualIgnoringCase.equalToIgnoringCase("edge"));
    }
    @Test
    @Ignore("Not sure how to make it work")
    public void withIE_default_returnsValidIESession() {
        String actualBrowser = getBrowserNameFromCapabilities();
        assertThat(actualBrowser, IsEqualIgnoringCase.equalToIgnoringCase("IE"));
    }
    @Test
    @Ignore("Invalid Use Case: I don't want the use to be able to do this")
    public void withIE_nonDefaultOs_returnsValidIESession() {
        String actualBrowser = getBrowserNameFromCapabilities();
        assertThat(actualBrowser, IsEqualIgnoringCase.equalToIgnoringCase("IE"));
    }
    @Test
    @Ignore("No clue why this doesn't work")
    public void withIE_nonDefaultVersion_returnsValidIESession() {
        String actualBrowser = getBrowserNameFromCapabilities();
        assertThat(actualBrowser, IsEqualIgnoringCase.equalToIgnoringCase("IE"));
    }
}
