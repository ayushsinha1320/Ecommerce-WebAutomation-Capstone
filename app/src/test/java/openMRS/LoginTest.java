package openMRS;

import openMRS.pages.OpenMRSLoginPage;
import openMRS.shared.PageWaits;
import openMRS.utils.ConfigReader;
import openMRS.utils.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {
    WebDriver driver = null;
    PageWaits waits = null;

    @BeforeClass
    public void setup() {
        this.driver = DriverCreator.instantiateDriver(ConfigReader.getBrowser());
        driver.get(ConfigReader.getBaseURL());
        //this.waits = PageWaits.getPageWaitsObject(this.driver);
    }

    //@Test(groups = {"sanity"})
    @Test
    public void testPDP() {
        OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(driver);
        loginPage.login("admin","Admin123");



    }

//    @AfterClass
//    public void tearDown() throws InterruptedException {
//        System.out.println("Terminating...");
//        sleep(3000);
//        driver.close();
//        driver.quit();
//    }


}
