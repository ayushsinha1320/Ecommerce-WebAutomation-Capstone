package openMRS.webautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverTest {

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("130.0.6723.59").setup();
    }

    @Test
    public void TestHello() {
        String actualTest = "Hello";
        String expectedTest = "Hello";
        Assert.assertEquals(actualTest, expectedTest);
        System.out.println("Hello from test");
    }
}