package openMRS;

import openMRS.pages.HomePage;
import openMRS.pages.OpenMRSLoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest() {
        OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(driver);
        loginPage.login("admin","Admin123");
        HomePage homePage = HomePage.getInstance(driver);
        String actualTitle = homePage.homePage();
        String expectedTitle = "Home";
        Assert.assertEquals(actualTitle,expectedTitle);
        loginPage.logout();
    }
    /*
        PLEASE WRITE A AFTER_CLASS ANNOTATION TO IMPLEMENT LOGOUT METHOD
     */
}
