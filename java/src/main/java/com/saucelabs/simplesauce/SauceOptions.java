package com.saucelabs.simplesauce;

import com.saucelabs.simplesauce.interfaces.RemoteDriverInterface;
import lombok.Setter;
import lombok.Getter;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SauceOptions {

    private final String sauceOptionsTag = "sauce:options";

    @Getter @Setter private MutableCapabilities options;

    @Getter @Setter private String platformName = "Windows 10";
    @Getter @Setter private String browserName = "Chrome";
    @Getter @Setter private String browserVersion = "latest";

    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;
    private EdgeOptions edgeOptions;
    private InternetExplorerOptions ieOptions;

    public SauceOptions() {
        this.options = new MutableCapabilities();
    }

    public SauceOptions(MutableCapabilities options){
        this.options = options;
    }

    public SauceOptions(DesiredCapabilities desiredCapabilities){
        this();
        this.parseDesiredCapibilities(desiredCapabilities);
    }

    private MutableCapabilities parseDesiredCapibilities(DesiredCapabilities desiredCapabilities) {
        return null;
    }

    public SauceOptions(String browserName, String browserVersion, String platformName){
        this();
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.platformName = platformName;
    }
}
