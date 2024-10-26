package openMRS.webautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class WebDriverTest {

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("130.0.6723.59").setup();
    }

    @Test
    public void TestHello(){
        System.out.println("Hello from test");
    }


}