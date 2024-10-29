package openMRS;

import openMRS.pages.OpenMRSLoginPage;
import openMRS.pages.RegisterPatientPage;
import openMRS.shared.PageWaits;
import openMRS.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class RegisterPatientTest {
    WebDriver driver = null;
    PageWaits waits;

    @BeforeClass
    public void setup() {
        this.driver = DriverCreator.instantiateDriver(ConfigReader.getBrowser());
        driver.get(ConfigReader.getBaseURL());
        this.waits = PageWaits.getPageWaitsObject(this.driver);
        OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(driver);
        loginPage.login("admin","Admin123");
    }

    @Test
    public void testRegisterPatient() {
        RegisterPatientPage registerPatientPage = RegisterPatientPage.getInstance(driver);
        registerPatientPage.RegisterPatient("Ayush","Sinha","Male","1","June","2000","Jamshedpur");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
