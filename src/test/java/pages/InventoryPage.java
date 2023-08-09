package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryPage extends Base{
    public InventoryPage(WebDriver driver){
        super(driver);
    }

    String add_to_cart_basic = "//*[@id='add-to-cart-";
    String remove_basic = "//*[@id='remove-";

    By item_num = By.xpath("//*[@id='shopping_cart_container']/a/span");
    String it1 = "item1";
    String it2 = "item2";

    public String getItem(String item){
        return properties.getProperty(item).toLowerCase().replace(' ', '-');
    }
    public String add_to_cart(String item){
        return add_to_cart_basic + getItem(item) + "']";
    }

    public String remove_from_cart(String item){
        return remove_basic + getItem(item) + "']";
    }

    public void add_first_item(){
        Assert.assertFalse(elementExist(item_num));
        click(By.xpath((add_to_cart(it1))));

        Assert.assertTrue(elementExist(item_num));
        Assert.assertEquals("1", getText(item_num));
    }

    public void remove_last_item(){
        click(By.xpath((remove_from_cart(it1))));
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
        click(By.xpath(( add ? add_to_cart(it2) : remove_from_cart(it2) )));
        int cur = Integer.parseInt(getText(item_num));

        Assert.assertTrue((cur - prev) == (add ? 1 : -1));
    }
}
