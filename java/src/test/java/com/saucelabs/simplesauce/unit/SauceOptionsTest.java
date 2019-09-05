package com.saucelabs.simplesauce.unit;

import com.saucelabs.simplesauce.SauceOptions;
import org.junit.Before;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.Test;

public class SauceOptionsTest {

    public SauceOptions sauceOptions;

    @Test
    public void defaultValues(){
        sauceOptions = new SauceOptions();

        assertEquals(sauceOptions.getBrowserName(), "chrome");
    }
}
