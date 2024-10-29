package openMRS.pages;

import openMRS.shared.Actions;
import openMRS.shared.FindElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {

    private static RegisterPatientPage registerPatientInstance;
    private final FindElements findElements;
    private final Actions actions;

    private RegisterPatientPage(WebDriver driver){
        this.findElements = FindElements.getInstance(driver);
        this.actions = Actions.getActionsObject(driver);
    }

    public static synchronized RegisterPatientPage getInstance(WebDriver driver) {
        if (registerPatientInstance == null) {
            registerPatientInstance = new RegisterPatientPage(driver);
        }
        return registerPatientInstance;
    }

    public void EnterGivenName(String GivenName){
        WebElement element = findElements.ByName("givenName");
        actions.type(element,GivenName);
    }

    public void EnterFamilyName(String FamilyName){
        WebElement element = findElements.ByName("familyName");
        actions.type(element,FamilyName);
    }

    public void EnterGender(String Gender){
        WebElement element = findElements.ByID("gender-field");
        Select select = new Select(element);
        select.selectByVisibleText(Gender);
    }

    public void EnterDateInDOB(String Date){
        WebElement element = findElements.ByName("birthdateDay");
        actions.type(element,Date);
    }
    public void EnterMonthInDOB(String Month){
        WebElement element = findElements.ByName("birthdateMonth");
        Select select = new Select(element);
        select.selectByVisibleText(Month);
    }
    public void EnterYearInDOB(String Year){
        WebElement element = findElements.ByName("birthdateYear");
        actions.type(element,Year);
    }

    public void EnterCity(String City){
        WebElement element = findElements.ByName("cityVillage");
        actions.type(element,City);
    }

    public void RegisterPatient(String GivenName,String FamilyName,String Gender,String Date,String Month,String Year,String City){
        EnterGivenName(GivenName);
        EnterFamilyName(FamilyName);
        EnterGender(Gender);
        EnterDateInDOB(Date);
        EnterMonthInDOB(Month);
        EnterYearInDOB(Year);
        EnterCity(City);
    }
}
