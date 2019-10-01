package com.saucelabs.simplesauce;

import com.saucelabs.simplesauce.interfaces.EnvironmentManager;
import com.saucelabs.simplesauce.interfaces.RemoteDriverInterface;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;

public class SauceSession {

    //todo there is some weird bug when this is set to Linux, the session can't be started
	private String operatingSystem = "Windows 10";
	private String browserName = "Chrome";
    private final String sauceOptionsTag = "sauce:options";

    private String browserVersion = "latest";
    public MutableCapabilities sauceSessionCapabilities;

    // goal is remove all members above this comment

    private final RemoteDriverInterface remoteDriverImplementation;
    @Getter private WebDriver webDriver;
    @Getter @Setter private SauceOptions sauceOptions;
    @Getter @Setter public final String sauceDataCenter = DataCenter.US_WEST;
    private final EnvironmentManager environmentManager;
    public SauceTimeout timeouts = new SauceTimeout();

    @Getter @Setter public String sauceLabsUrl;

    public SauceSession() {
        sauceSessionCapabilities = new SauceOptions();
        remoteDriverImplementation = new ConcreteRemoteDriver();
        environmentManager = new ConcreteSystemManager();
    }

    public SauceSession(RemoteDriverInterface remoteManager, EnvironmentManager environmentManager) {
        remoteDriverImplementation = remoteManager;
        sauceSessionCapabilities = new SauceOptions();
        this.environmentManager = environmentManager;
    }

    public SauceSession(MutableCapabilities options){
        sauceSessionCapabilities = options;
        remoteDriverImplementation = new ConcreteRemoteDriver();
        environmentManager = new ConcreteSystemManager();
    }

    public WebDriver start() {
        sauceSessionCapabilities = setRemoteDriverCapabilities(this.sauceOptions);
        sauceLabsUrl = sauceDataCenter;
        try
        {
            webDriver = remoteDriverImplementation.createRemoteWebDriver(sauceLabsUrl, sauceSessionCapabilities);
        }
        catch (MalformedURLException e)
        {
            throw new InvalidArgumentException("Invalid URL");
        }
        return this.webDriver;
	}

    public void stop()
    {
        if(webDriver != null)
            webDriver.quit();
    }

    private MutableCapabilities setRemoteDriverCapabilities(MutableCapabilities sauceOptions) {
        sauceSessionCapabilities.setCapability(sauceOptionsTag, sauceOptions);
        sauceSessionCapabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        sauceSessionCapabilities.setCapability(CapabilityType.PLATFORM_NAME, operatingSystem);
        sauceSessionCapabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
        return sauceSessionCapabilities;
    }

    public RemoteDriverInterface getDriverManager() {
        return remoteDriverImplementation;
    }

    private String checkIfEmpty(String variableToCheck) {
        if (variableToCheck == null)
            throw new SauceEnvironmentVariablesNotSetException();
        return variableToCheck;
    }

    public String getUserName() throws SauceEnvironmentVariablesNotSetException{
        String userName = environmentManager.getEnvironmentVariable("SAUCE_USERNAME");
        return checkIfEmpty(userName);
    }

    public String getAccessKey() throws SauceEnvironmentVariablesNotSetException {
        String accessKey = environmentManager.getEnvironmentVariable("SAUCE_ACCESS_KEY");
        return checkIfEmpty(accessKey);
    }

}
