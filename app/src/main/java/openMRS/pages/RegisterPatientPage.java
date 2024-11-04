package openMRS.pages;

import openMRS.shared.Actions;
import openMRS.shared.FindElements;
import openMRS.shared.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {

    private static RegisterPatientPage registerPatientInstance;
    private final FindElements findElements;
    private final Actions actions;
    private final PageWaits waits;


    private RegisterPatientPage(WebDriver driver){
        this.findElements = FindElements.getInstance(driver);
        this.actions = Actions.getActionsObject(driver);
        this.waits = PageWaits.getPageWaitsObject(driver);
    }

    public static synchronized RegisterPatientPage getInstance(WebDriver driver) {
        if (registerPatientInstance == null) {
            registerPatientInstance = new RegisterPatientPage(driver);
        }
        return registerPatientInstance;
    }

    public void EnterGivenName(String GivenName){
        this.waits.waitUntilElementFoundByName("givenName");
        WebElement element = findElements.ByName("givenName");
        actions.type(element,GivenName);
    }

    public void EnterFamilyName(String FamilyName){
        this.waits.waitUntilElementFoundByName("familyName");
        WebElement element = findElements.ByName("familyName");
        actions.type(element,FamilyName);
    }

    public void EnterGender(String Gender){
        this.waits.waitUntilElementFoundByID("gender-field");
        WebElement element = findElements.ByID("gender-field");
        Select select = new Select(element);
        select.selectByVisibleText(Gender);
    }

    public void EnterDateInDOB(String Date){
        this.waits.waitUntilElementFoundByName("birthdateDay");
        WebElement element = findElements.ByName("birthdateDay");
        actions.type(element,Date);
    }
    public void EnterMonthInDOB(String Month){
        this.waits.waitUntilElementFoundByName("birthdateMonth");
        WebElement element = findElements.ByName("birthdateMonth");
        Select select = new Select(element);
        select.selectByVisibleText(Month);
    }
    public void EnterYearInDOB(String Year){
        this.waits.waitUntilElementFoundByName("birthdateYear");
        WebElement element = findElements.ByName("birthdateYear");
        actions.type(element,Year);
    }

    public void EnterCity(String City){
        this.waits.waitUntilElementFoundByID("cityVillage");
        WebElement element = findElements.ByID("cityVillage");
        actions.type(element,City);
    }

    public void ClickTheElementByID(String Element){
        this.waits.waitUntilElementFoundByID(Element);
        WebElement element = findElements.ByID(Element);
        actions.clickElement(element);
    }

    public void deletePatientByName(String name) throws InterruptedException {
        actions.navigateTo("https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient");
        WebElement searchBox = findElements.ByID("patient-search");
        actions.type(searchBox,name);
        WebElement patient = findElements.ByXPath("//tr[@class=\"odd\"]");
        actions.clickElement(patient);
        WebElement deleteText = findElements.ByXPath("//*[@id=\"org.openmrs.module.coreapps.deletePatient\"]/div/div[2]");
        actions.clickElement(deleteText);
        WebElement deleteReasonTextBox = findElements.ByID("delete-reason");
        actions.type(deleteReasonTextBox,"testing");
        WebElement confirmButton = findElements.ByXPath("//*[@id=\"delete-patient-creation-dialog\"]/div[2]/button[1]");
        actions.clickElement(confirmButton);
        Thread.sleep(5000);
        actions.navigateTo("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
    }

    public void RegisterPatient(String GivenName,String FamilyName,String Gender,String Date,String Month,String Year,String City) throws InterruptedException {

        WebElement RegisterAPatientElement = findElements.ByID("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
        RegisterAPatientElement.click();

        EnterGivenName(GivenName);
        EnterFamilyName(FamilyName);
        ClickTheElementByID("next-button");
        EnterGender(Gender);
        ClickTheElementByID("next-button");
        EnterDateInDOB(Date);
        EnterMonthInDOB(Month);
        EnterYearInDOB(Year);
        ClickTheElementByID("next-button");
        EnterCity(City);
        ClickTheElementByID("next-button");
        ClickTheElementByID("next-button");
        ClickTheElementByID("next-button");
        ClickTheElementByID("submit");
        Thread.sleep(5000);
        actions.navigateTo("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
    }
}
