package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends Base{
    public ProductsPage(WebDriver driver){
        super(driver);
    }

    By item_num = By.xpath("//*[@id='shopping_cart_container']/a/span");

    public void add_first_item(){
        Assert.assertFalse(elementExist(item_num));
        click(By.xpath((add_to_cart(testData.item1))));

        Assert.assertTrue(elementExist(item_num));
        Assert.assertEquals("1", getText(item_num));
    }

    public void remove_last_item(){
        click(By.xpath((remove_from_cart(testData.item1))));
        Assert.assertFalse(elementExist(item_num));
    }

    public void add_item(){
        cart_interaction(true);
    }
    public void remove_item(){
        cart_interaction(false);
    }

    public void cart_interaction(boolean add){
        int prev = Integer.parseInt(getText(item_num));
        click(By.xpath(( add ? add_to_cart(testData.item2) : remove_from_cart(testData.item2))));
        int cur = Integer.parseInt(getText(item_num));

        Assert.assertTrue((cur - prev) == (add ? 1 : -1));
    }
}
