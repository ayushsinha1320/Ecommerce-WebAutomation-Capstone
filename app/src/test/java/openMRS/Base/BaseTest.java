package openMRS.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName){

        switch (browserName){

            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Please enter valid browser name");
                break;
        }

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
