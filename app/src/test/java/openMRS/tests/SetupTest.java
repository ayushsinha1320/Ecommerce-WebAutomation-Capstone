package openMRS.tests;

import openMRS.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetupTest extends BaseTest {

    @Test
    public void LoginPageTitleTest(){
        Assert.assertEquals(driver.getTitle(),"Login");
    }
}
