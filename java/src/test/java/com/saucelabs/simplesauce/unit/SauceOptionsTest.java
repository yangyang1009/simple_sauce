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
    public void acceptBrowserName() {
        sauceOptions = new SauceOptions("Firefox");

        assertEquals(sauceOptions.getBrowserName(), "Firefox");
        assertEquals(sauceOptions.getBrowserVersion(), "latest");
        assertEquals(sauceOptions.getPlatformName(), "Windows 10");
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
