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

    public void clickConfigPrivileges(){
        WebElement configureMetadata = findElements.ByCSS("#org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension");
        actions.clickElement(configureMetadata);
    }

    public void clickManagePrivileges(){
        WebElement managePrivileges = findElements.ByCSS("#org-openmrs-module-adminui-Privileges-org-openmrs-module-adminui-Privileges-extension");
        actions.clickElement(managePrivileges);

    }

    public void addNewPrivilege(){
        WebElement addNewPrivileges = findElements.ByXPath("//input[@class=\"button\"]");
        actions.clickElement(addNewPrivileges);

    }

    public void enterName(String privilegeName){
        WebElement name = findElements.ByID("privilege-field");
        actions.type(name,privilegeName);
    }

    public  void clickSubmit(){
        WebElement submit = findElements.ByClass("confirm");
        actions.clickElement(submit);

    }

    public void managePrivileges(String username) throws InterruptedException {
        clickConfigPrivileges();
        clickManagePrivileges();
        addNewPrivilege();
        enterName(username);
        clickSubmit();
        Thread.sleep(3000);
        actions.navigateTo("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
    }
}
