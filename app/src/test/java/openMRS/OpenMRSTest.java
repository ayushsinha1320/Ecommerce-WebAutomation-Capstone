package openMRS;

import openMRS.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class OpenMRSTest extends BaseTest{

    private final String currentPassword = "Testing@321";
    OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(driver);

    @BeforeTest
    public void Login() {
//        loginPage.login("testuser",currentPassword);
        loginPage.login("admin","Admin123");

    }
    @AfterTest
    public void logout(){
        loginPage.logout();
    }

    @Test
    public void HomePageTitleTest(){
        HomePage homePage = HomePage.getInstance(driver);
        String actualTitle = homePage.homePage();
        String expectedTitle = "Home";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void testRegisterPatient() {
        RegisterPatientPage registerPatientPage = RegisterPatientPage.getInstance(driver);
        registerPatientPage.RegisterPatient("Ayush","Sinha","Male","1","June","2000","Jamshedpur");
    }

    @Test
    public void testMST() throws InterruptedException {
        OpenManageServiceType openManageServiceType = OpenManageServiceType.getInstance(driver);
        openManageServiceType.manageServiceType("Medicine","10");
    }

    @Test
    public void testMPT() {
        OpenMRSManagePrivileges managePrivileges = OpenMRSManagePrivileges.getInstance(driver);
        managePrivileges.managePrivileges("Allergy in Skin");
    }

    @Test
    public void EditPasswordTest(){
        /*
            PLEASE UPDATE THE oldPassword and newPassword before running the code
         */
        String newPassword = "Testing@321";
        EditPasswordPage editPasswordPage = EditPasswordPage.getInstance(driver);
        editPasswordPage.editPassword(currentPassword,newPassword);
        String actual = driver.getTitle();
        String expected = "My Account";
        Assert.assertEquals(actual,expected);
    }
}