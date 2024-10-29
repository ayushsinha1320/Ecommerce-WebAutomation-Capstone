package openMRS.pages;

import openMRS.shared.Actions;
import openMRS.shared.FindElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenMRSLoginPage {
    private static OpenMRSLoginPage loginPageInstance;
    private WebDriver driver;
    private FindElements findElements;
    private Actions actions;
    String userName;
    String password;

    private OpenMRSLoginPage(WebDriver driver) {
        this.driver = driver;
        this.findElements = FindElements.getInstance(driver);
        this.actions = Actions.getActionsObject(driver);
    }

    public static synchronized OpenMRSLoginPage getInstance(WebDriver driver) {
        if (loginPageInstance == null) {
            loginPageInstance = new OpenMRSLoginPage(driver);
        }
        return loginPageInstance;
    }

    public void enterUserName(String userName){
        WebElement usernameField = findElements.ByCSS("#username");

        actions.type(usernameField, userName);
    }
    public void enterPassword(String password){
        WebElement passwordField = findElements.ByCSS("#password");
        actions.type(passwordField, password);
    }

    public void clickLocation(){
        WebElement location = findElements.ByCSS("#Inpatient\\ Ward");
        actions.clickElement(location);
    }

    public void clickLiginButton(){
        WebElement loginButton = findElements.ByCSS("#loginButton");
        actions.clickElement(loginButton);
    }




    public void login(String username, String password) {

        enterUserName(username);
        enterPassword(password);
        clickLocation();
        clickLiginButton();
    }

}
