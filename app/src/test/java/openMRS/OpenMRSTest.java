package openMRS;

import openMRS.pages.EditPasswordPage;
import openMRS.pages.HomePage;
import openMRS.pages.OpenMRSLoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class OpenMRSTest {

    BaseTest baseTest = new BaseTest();
    private final String currentPassword = "Testing@123";

    @BeforeTest
    public void setup(){
        baseTest.setup();
    }
    @AfterTest
    public void tearDown() throws InterruptedException {baseTest.tearDown();}
    @BeforeClass
    public void Login() {
        OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(baseTest.driver);
        loginPage.login("testuser",currentPassword);
    }

    @Test
    public void HomePageTitleTest(){
        HomePage homePage = HomePage.getInstance(baseTest.driver);
        String actualTitle = homePage.homePage();
        String expectedTitle = "Home";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void EditPasswordTest(){
        /*
            PLEASE UPDATE THE oldPassword and newPassword before running the code
         */
        String newPassword = "Testing@321";
        EditPasswordPage editPasswordPage = EditPasswordPage.getInstance(baseTest.driver);
        editPasswordPage.editPassword(currentPassword,newPassword);
        String actual = baseTest.driver.getTitle();
        String expected = "My Account";
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void managePrivilege(){

    }

}