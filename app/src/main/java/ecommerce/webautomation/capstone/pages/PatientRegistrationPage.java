package ecommerce.webautomation.capstone.pages;

import ecommerce.webautomation.capstone.shared.Actions;
import ecommerce.webautomation.capstone.shared.FindElements;
import ecommerce.webautomation.capstone.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PatientRegistrationPage {

    private static PatientRegistrationPage patientRegistrationPage = null;
    private WebDriver driver = null;
    Actions actions = null;
    FindElements findElements = null;

    private PatientRegistrationPage(WebDriver driver){
        this.driver = driver;
        this.actions = Actions.getActionsObject(driver);
        this.findElements = FindElements.getInstance(driver);
    }

    public static PatientRegistrationPage getInstance(WebDriver driver){
        if(patientRegistrationPage == null){
            PatientRegistrationPage.patientRegistrationPage = new PatientRegistrationPage(driver);
        }
        return PatientRegistrationPage.patientRegistrationPage;
    }

    public void goToRegistrationPage(){
        actions.navigateTo(ConfigReader.getRegistrationURL());
    }

    public WebElement getElement(String element,String data){
        WebElement foundElement = null;
        switch (element.toLowerCase()){
            case "name":
                foundElement = findElements.ByName(data);
                break;
            case "id":
                foundElement = findElements.ByID(data);
                break;
            default:
                System.out.println("Please enter valid element");
                break;
        }
        return foundElement;
    }

    public void enterData(WebElement element,String data){
        actions.type(element,data);
    }
}
