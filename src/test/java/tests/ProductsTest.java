package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.LoginPage;

public class ProductsTest extends BaseTest{
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeTest
    private void setup(){
        super.setUp();
        loginPage = new LoginPage(this.driver);
        productsPage = new ProductsPage(this.driver);
        loginPage.login();
    }

    @Test(priority = -1)
    public void addOneItemTest() {
        productsPage.add_first_item();
    }

    @Test(priority = 1, dependsOnMethods = { "addOneItemTest" })
    public void addAnotherItemTest() {
        productsPage.add_item();
    }

    @Test(priority = 2, dependsOnMethods = { "addOneItemTest" })
    public void removeOneItemTest() {
        productsPage.remove_item();
    }

    @Test(priority = 3, dependsOnMethods = { "addOneItemTest" })
    public void removeLastItemTest() {
        productsPage.remove_last_item();
    }

    @AfterTest
    private void cleanup(){
//        driver.quit();
    }
}
