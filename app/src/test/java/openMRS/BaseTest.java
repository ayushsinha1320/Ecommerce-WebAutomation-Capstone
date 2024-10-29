package openMRS;

import openMRS.shared.PageWaits;
import openMRS.utils.ConfigReader;
import openMRS.utils.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.lang.Thread.sleep;

public class BaseTest {
    WebDriver driver = null;
    PageWaits waits = null;

    @BeforeClass
    public void setup() {
        this.driver = DriverCreator.instantiateDriver(ConfigReader.getBrowser());
        driver.get(ConfigReader.getBaseURL());
        this.waits = PageWaits.getPageWaitsObject(this.driver);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("Terminating...");
        sleep(3000);
        driver.close();
        driver.quit();





    }
}
