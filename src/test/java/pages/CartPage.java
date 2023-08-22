package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class CartPage extends Base{
    public CartPage(WebDriver driver){
        super(driver);
    }

    By itemNames = By.xpath("//*[@class='inventory_item_name']");
    By shoppingCart = By.xpath("//*[@class='shopping_cart_badge']");
    By continueShopping = By.xpath("//*[@id='continue-shopping']");
    By cart_icon = By.xpath("//*[@id='shopping_cart_container']/a");
    By title = By.xpath("//*[@class='title']");

    public void goToCartPage(){
        click(cart_icon);
    }

    public void confirmFirstItem(){
        List<String> inventory = getTextList(itemNames);
        Assert.assertTrue(inventory.size() == 1);
        Assert.assertTrue(inventory.get(0).equals(testData.item1));
    }

    public void removeFirstItems(){
        click(By.xpath(remove_from_cart(testData.item1)));
        emptyCart();
    }

    public void emptyCart(){
        Assert.assertFalse(elementExist(shoppingCart));
    }

    public void clickContinueShopping(){
        click(continueShopping);
        Assert.assertTrue(getText(title).equals("Products"));
    }
}
