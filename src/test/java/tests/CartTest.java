package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class CartTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeTest
    private void setup(){
        super.setUp();
        loginPage = new LoginPage(this.driver);
        productsPage = new ProductsPage(this.driver);
        cartPage = new CartPage(this.driver);
        loginPage.login();

    }

    @Test
    public void emptyCart(){
        cartPage.goToCartPage();
        cartPage.emptyCart();
    }

    @Test

    @Test
    public void confirmFirstItemInCart(){
        productsPage.add_first_item();
        cartPage.goToCartPage();
        cartPage.confirmFirstItem();
    }

    @AfterTest
    private void cleanup(){
//        driver.quit();
    }
}