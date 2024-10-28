package openMRS.tests;
import openMRS.Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class EditRegistrationInformationTest extends BaseTest {

    @Test
    public void editDemographicsButton(){
        driver.findElement(By.id("demographics-edit-link"));
    }
}
