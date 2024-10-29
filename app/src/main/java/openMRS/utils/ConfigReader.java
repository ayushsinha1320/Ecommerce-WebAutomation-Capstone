package openMRS.utils;


public class ConfigReader {
    private static final String baseURL = "https://demo.openmrs.org/openmrs/login.htm";
    private static final String browser = "chrome";

    public static String getBrowser() {
        return browser;
    }

    public static String getBaseURL() {
        return baseURL;
    }
}