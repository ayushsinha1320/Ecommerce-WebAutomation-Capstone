package openMRS;

import openMRS.pages.OpenMRSLoginPage;
import openMRS.pages.OpenMRSManagePrivileges;
import openMRS.shared.PageWaits;
import openMRS.utils.ConfigReader;
import openMRS.utils.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManagePrivilegesTest {

    WebDriver driver = null;
    PageWaits waits = null;

    @BeforeTest
    public void setup() {
        this.driver = DriverCreator.instantiateDriver(ConfigReader.getBrowser());
        driver.get(ConfigReader.getBaseURL());
        this.waits = PageWaits.getPageWaitsObject(this.driver);
        OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(driver);
        loginPage.login("admin","Admin123");

    }

    @Test
    public void testMPT() {
        OpenMRSManagePrivileges managePrivileges = OpenMRSManagePrivileges.getInstance(driver);
        managePrivileges.managePrivileges("Allergy in Skin");
    }
}