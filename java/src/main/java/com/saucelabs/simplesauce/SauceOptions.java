package com.saucelabs.simplesauce;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class SauceOptions extends MutableCapabilities {

    private final String sauceOptionsTag = "sauce:options";

    @Getter @Setter private MutableCapabilities options;

    @Getter private String platformName = "Windows 10";
    @Getter private String browserName = "Chrome";
    @Getter private String browserVersion = "latest";

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

    public SauceOptions(String browserName) {
        setBrowserName(browserName);
        this.setBrowserSpecificCapabilities(browserName);
    }
    
    // from original SauceSession approach
    private void setBrowserSpecificCapabilities(String browserName)
    {
        if (browserName.equalsIgnoreCase("Chrome"))
        {
            this.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }
        else if (browserName.equalsIgnoreCase("Firefox"))
        {
            this.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
        }
        else if(browserName.equalsIgnoreCase("Safari"))
        {
            SafariOptions safariOptions = new SafariOptions();
            this.setCapability(SafariOptions.CAPABILITY, safariOptions);
        }
        else if(browserName.equalsIgnoreCase("Edge"))
        {
            this.setCapability("Edge", edgeOptions);
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
            this.setCapability("se:ieOptions", ieOptions);
        }
        else {
            throw new IllegalArgumentException("The browser=>" + browserName + " that you passed in is not a valid option.");
        }
    }

    public SauceOptions withChrome()
    {
        chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", true);
        this.setCapability("browserName", "Chrome");
        return this;
    }

    public SauceOptions withSafari(String version)
    {
        //TODO: I did this but I hate it :(
        //I wish I could just have a default value set for the version param
        if(version.equalsIgnoreCase(""))
            version = "latest";
        browserName = "safari";
        this.browserVersion = version;
        return this;
    }
    public SauceOptions withSafari()
    {
        return withMacOsMojave();
    }

    public SauceOptions withFirefox()
    {
        browserName = "Firefox";
        return this;
    }

    public SauceOptions withMacOsMojave() {
        platformName = "macOS 10.14";
        browserName = "safari";
        browserVersion = "12.0";
        return this;
    }
    public SauceOptions withMacOsHighSierra()
    {
        platformName = "macOS 10.13";
        browserName = "Safari";
        return this;
    }

    public SauceOptions withEdge() {
        browserName = "Edge";
        edgeOptions = new EdgeOptions();
        return this;
    }

    public SauceOptions withIE(String version) {
        this.browserName = "IE";
        this.browserVersion = version;
        ieOptions = new InternetExplorerOptions();
        return this;
    }

    public SauceOptions withPlatform(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public SauceOptions withMacOsSierra() {
        this.platformName = "macOS 10.12";
        browserName = "Safari";
        return this;
    }

    public SauceOptions withMacOsXElCapitan() {
        this.platformName = "OS X 10.11";
        browserName = "Safari";
        return this;
    }

    public SauceOptions withMacOsXYosemite() {
        this.platformName = "OS X 10.10";
        browserName = "Safari";
        return this;
    }
    //TODO notice the duplication below with edge.
    //Maybe could be moved to a separate class so we can do withEdge().16_16299();
    //Or withEdge().version(EdgeVersion.16_16299);
    public SauceOptions withEdge16_16299() {
        browserName = "Edge";
        browserVersion = "16.16299";
        return this;
    }

    public SauceOptions withEdge15_15063() {
        browserName = "Edge";
        browserVersion = "15.15063";
        return this;
    }

    public SauceOptions withEdge14_14393() {
        browserName = "Edge";
        browserVersion = "14.14393";
        return this;
    }

    public SauceOptions withEdge13_10586() {
        browserName = "Edge";
        browserVersion = "13.10586";
        return this;
    }

    public SauceOptions withEdge17_17134() {
        browserName = "Edge";
        browserVersion = "17.17134";
        return this;
    }

    public SauceOptions withEdge18_17763() {
        browserName = "Edge";
        browserVersion = "18.17763";
        return this;
    }

    public SauceOptions withWindows10() {
        platformName = "Windows 10";
        return this;
    }

    public SauceOptions withWindows8_1() {
        platformName = "Windows 8.1";
        return this;
    }

    public SauceOptions withWindows8() {
        platformName = "Windows 8";
        return this;
    }

    public SauceOptions withWindows7() {
        platformName = "Windows 7";
        return this;
    }

    public SauceOptions withLinux() {
        platformName = "Linux";
        return this;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
        this.setCapability("platformName", platformName);
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
        this.setCapability("browserName", browserName);
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
        this.setCapability("browserVersion", browserVersion);
    }
}
