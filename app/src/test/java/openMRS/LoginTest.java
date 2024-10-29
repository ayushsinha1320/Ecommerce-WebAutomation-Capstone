package openMRS;

import openMRS.pages.OpenMRSLoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testPDP() {
        OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(driver);
        loginPage.login("admin","Admin123");
    }

}
