package com.saucelabs.simplesauce.unit;

import com.saucelabs.simplesauce.SauceOptions;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SauceOptionsTest {

    public SauceOptions sauceOptions;

    @Test
    public void defaultValues(){
        sauceOptions = new SauceOptions();

        assertEquals(sauceOptions.getBrowserName(), "Chrome");
        assertEquals(sauceOptions.getBrowserVersion(), "latest");
        assertEquals(sauceOptions.getPlatformName(), "Windows 10");
    }

    @Test
    public void acceptsBrowserVersionBrowserNamePlatformName() {
        sauceOptions = new SauceOptions("Firefox", "68.0", "macOS 10.13");

        assertEquals(sauceOptions.getBrowserName(), "Firefox");
        assertEquals(sauceOptions.getBrowserVersion(), "68.0");
        assertEquals(sauceOptions.getPlatformName(), "macOS 10.13");
    }

    @Test
    @Ignore("Future enhancement")
    public void acceptsMutableCababilities() {
        throw new NotImplementedException("TODO");
    }

    @Test
    @Ignore("Future enhancement")
    public void acceptsDesiredCapabilities() {
        throw new NotImplementedException("TODO");
    }
}
