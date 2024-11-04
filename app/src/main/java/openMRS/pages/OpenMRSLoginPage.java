package openMRS.pages;

import openMRS.shared.Actions;
import openMRS.shared.FindElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenMRSLoginPage {
    private static OpenMRSLoginPage loginPageInstance;
    private final FindElements findElements;
    private final Actions actions;

    private OpenMRSLoginPage(WebDriver driver) {
        this.findElements = FindElements.getInstance(driver);
        this.actions = Actions.getActionsObject(driver);
    }

    public static synchronized OpenMRSLoginPage getInstance(WebDriver driver) {
        if (loginPageInstance == null) {
            loginPageInstance = new OpenMRSLoginPage(driver);
        }
        return loginPageInstance;
    }

    private void enterUserName(String userName){
        WebElement usernameField = findElements.ByCSS("#username");

        actions.type(usernameField, userName);
    }
    private void enterPassword(String password){
        WebElement passwordField = findElements.ByCSS("#password");
        actions.type(passwordField, password);
    }

    private void clickLocation(){
        WebElement location = findElements.ByCSS("#Inpatient\\ Ward");
        actions.clickElement(location);
    }

    private void clickLoginButton(){
        WebElement loginButton = findElements.ByCSS("#loginButton");
        actions.clickElement(loginButton);
    }

    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLocation();
        clickLoginButton();
    }

    public void logout(){
        WebElement logoutButton = findElements.ByXPath("//div[@id='navbarSupportedContent']/ul/li[3]/a");
        actions.clickElement(logoutButton);
    }

}
