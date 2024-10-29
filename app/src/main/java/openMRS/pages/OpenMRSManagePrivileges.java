package openMRS.pages;

import openMRS.shared.Actions;
import openMRS.shared.FindElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenMRSManagePrivileges {

    private static OpenMRSManagePrivileges managePrivilegesInstance;
    private WebDriver driver;
    private FindElements findElements;
    private Actions actions;

    public OpenMRSManagePrivileges(WebDriver driver) {
        this.driver = driver;
        this.findElements = FindElements.getInstance(driver);
        this.actions = Actions.getActionsObject(driver);
    }

    public static synchronized OpenMRSManagePrivileges getInstance(WebDriver driver) {
        if (managePrivilegesInstance == null) {
            managePrivilegesInstance = new OpenMRSManagePrivileges(driver);
        }
        return managePrivilegesInstance;
    }

    public void managePrivileges(String username) {
        WebElement configureMetadata = findElements.ByCSS("#org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension");
        WebElement managePrivileges = findElements.ByCSS("#org-openmrs-module-adminui-Privileges-org-openmrs-module-adminui-Privileges-extension");
        WebElement addNewPrivileges = findElements.ByXPath("//input[@class=\"button\"]");
        WebElement name = findElements.ByID("privilege-field");
        WebElement submit = findElements.ByClass("confirm");

        actions.clickElement(configureMetadata);
        actions.clickElement(managePrivileges);
        actions.clickElement(addNewPrivileges);
        name.sendKeys(username);
        submit.click();
    }
}
