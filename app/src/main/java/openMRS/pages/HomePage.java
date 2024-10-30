package openMRS.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private static HomePage homePageInstance;
    private final WebDriver driver;

    private HomePage(WebDriver driver){
        this.driver = driver;
    }

    public static synchronized HomePage getInstance(WebDriver driver) {
        if (homePageInstance == null) {
            homePageInstance = new HomePage(driver);
        }
        return homePageInstance;
    }

    public String homePage(){
        driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
        return this.driver.getTitle();
    }
}
