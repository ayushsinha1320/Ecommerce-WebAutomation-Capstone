package openMRS.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.cssSelector("#username");
    private By passwordField = By.cssSelector("#password");
    private By location = By.cssSelector("#Inpatient\\ Ward");
    private By loginButton = By.cssSelector("#loginButton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLocation(){
        driver.findElement(location).click();
    }


    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLocation();
        clickLogin();
    }
}
