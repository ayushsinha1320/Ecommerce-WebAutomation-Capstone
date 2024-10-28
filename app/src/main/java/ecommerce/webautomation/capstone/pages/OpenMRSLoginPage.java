package ecommerce.webautomation.capstone.pages;

import ecommerce.webautomation.capstone.shared.Actions;
import ecommerce.webautomation.capstone.shared.FindElements;
import ecommerce.webautomation.capstone.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenMRSLoginPage {
    private static OpenMRSLoginPage loginPageInstance;
    private WebDriver driver;
    private FindElements findElements;

    private OpenMRSLoginPage(WebDriver driver) {
        this.driver = driver;
        this.findElements = FindElements.getInstance(driver);
    }

    public static synchronized OpenMRSLoginPage getInstance(WebDriver driver) {
        if (loginPageInstance == null) {
            loginPageInstance = new OpenMRSLoginPage(driver);
        }
        return loginPageInstance;
    }

    public void login(String username, String password) {
        WebElement usernameField = findElements.ByCSS("#username");
        WebElement passwordField = findElements.ByCSS("#password");
        WebElement location = findElements.ByCSS("#Inpatient\\ Ward");
        WebElement loginButton = findElements.ByCSS("#loginButton");

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        location.click();
        loginButton.click();


    }



}
