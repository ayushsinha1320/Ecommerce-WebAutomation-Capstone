package ecommerce.webautomation.capstone;

import ecommerce.webautomation.capstone.shared.PageWaits;
import ecommerce.webautomation.capstone.utils.ConfigReader;
import ecommerce.webautomation.capstone.utils.DriverCreator;
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
