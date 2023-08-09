package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest{
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeTest
    private void setup(){
        super.setUp();
        loginPage = new LoginPage(this.driver);
        inventoryPage = new InventoryPage(this.driver);
        loginPage.login();
    }

    @Test(priority = -1)
    public void addOneItemTest() {
        inventoryPage.add_first_item();
    }

    @Test(priority = 1, dependsOnMethods = { "addOneItemTest" })
    public void addAnotherItemTest() {
        inventoryPage.add_item();
    }

    @Test(priority = 2, dependsOnMethods = { "addOneItemTest" })
    public void removeOneItemTest() {
        inventoryPage.remove_item();
    }

    @Test(priority = 3, dependsOnMethods = { "addOneItemTest" })
    public void removeLastItemTest() {
        inventoryPage.remove_last_item();
    }

    @AfterTest
    private void cleanup(){
        driver.quit();
    }
}
