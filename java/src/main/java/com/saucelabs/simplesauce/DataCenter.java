package com.saucelabs.simplesauce;

public class DataCenter
{
    private static String USWestBaseUrl = "ondemand.saucelabs.com/wd/hub";
    private static String USEastBaseUrl = "ondemand.us-east-1.saucelabs.com/wd/hub";
    private static String EUCentralBaseUrl = "ondemand.eu-central-1.saucelabs.com/wd/hub";

    public enum RemoteUrls {
        US_WEST("https://" + USWestBaseUrl),
        US_EAST("https://" + USEastBaseUrl),
        EU_CENTRAL("https://" + EUCentralBaseUrl);

        public final String address;

        private RemoteUrls(String address) {
            this.address = address;
        }
    }

    public String getAuthenticatedRemoteUrl(String username, String accessKey){
        return String.format("https://%s:%s@%s", username, accessKey, RemoteUrls.US_WEST.address);
    }

    public String getAutheticatedRemoteUrl(String username, String accessKey, RemoteUrls url) {
        if (url == RemoteUrls.US_EAST) {
            return String.format("https://%s:%s@%s", username, accessKey, RemoteUrls.US_EAST.address);
        } else if (url == RemoteUrls.EU_CENTRAL) {
            return String.format("https://%s:%s@%s", username, accessKey, RemoteUrls.EU_CENTRAL.address);
        } else {
            return String.format("https://%s:%s@%s", username, accessKey, RemoteUrls.US_WEST.address);
        }
    }
}
