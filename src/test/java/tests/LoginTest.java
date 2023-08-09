package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

public class LoginTest extends BaseTest{
	LoginPage loginPage;

    @BeforeTest
	private void setup(){
        super.setUp();
        loginPage = new LoginPage(this.driver);
    }

    @Test
    public void loginTest() {
        loginPage.login();
    }

    @AfterTest
    private void cleanup(){
        driver.quit();
    }
}