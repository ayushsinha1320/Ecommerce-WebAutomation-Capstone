package openMRS.webautomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void basicTest(){
        String hello = "Say Hello";
        Assert.assertEquals(hello, "Say Hello");
    }
}
