package openMRS;

import openMRS.pages.OpenMRSLoginPage;
import org.testng.annotations.*;

public class OpenMRSTest {

    BaseTest baseTest = new BaseTest();

    @BeforeTest
    public void setup(){
        baseTest.setup();
    }

    @BeforeClass
    public void checkLogin() {
        OpenMRSLoginPage loginPage = OpenMRSLoginPage.getInstance(baseTest.driver);
        loginPage.login("admin","Admin123");
    }


    @Test
    public void managePrivilege(){

    }

    }

