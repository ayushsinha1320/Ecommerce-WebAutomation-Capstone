package openMRS.pages;

import org.openqa.selenium.WebDriver;
import openMRS.shared.Actions;

public class HomePage {
    private static HomePage homePage = null;
    private Actions actions = null;

    private HomePage(WebDriver driver) {
        this.actions = Actions.getActionsObject(driver);
    }

    public static HomePage getInstance(WebDriver driver) {
        if (homePage == null) {
            HomePage.homePage = new HomePage(driver);
        }
        return HomePage.homePage;
    }


}
