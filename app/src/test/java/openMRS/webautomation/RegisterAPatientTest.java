package openMRS.webautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RegisterAPatientTest {
    WebDriver driver ;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);


        loginPage.login("admin", "Admin123");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Assert.assertEquals(driver.getTitle(), "https://demo.openmrs.org/openmrs/login.htm");

    }

    @Test
    public void testRegisterPatient() {
        driver.findElement(By.cssSelector("#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
        driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Bob");
        driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys("Smith");
        driver.findElement(By.cssSelector("#next-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        driver.findElement(By.cssSelector("#gender-field > option:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#next-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        driver.findElement(By.xpath("//*[@id=\"birthdateDay-field\"]")).sendKeys("09");

        WebElement month = driver.findElement(By.cssSelector("#birthdateMonth-field"));
        month.click();
        List<WebElement> options = month .findElements(By.tagName("option"));

        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals("April")) {
                option.click();
                System.out.println("Selected: " + optionText);

            }
        }

        driver.findElement(By.cssSelector("#birthdateYear-field")).sendKeys("2001");
        driver.findElement(By.cssSelector("#next-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));


        driver.findElement(By.id("cityVillage")).sendKeys("Bengaluru");
        driver.findElement(By.cssSelector("#next-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

       // driver.findElement(By.xpath("//*[@id=\"fr9474-field\"]")).sendKeys("9087654321");
        driver.findElement(By.cssSelector("#next-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        driver.findElement(By.cssSelector("#next-button")).click();

        driver.findElement(By.cssSelector("#submit")).click();


    }

}
