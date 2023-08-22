package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.TestData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Base {
	public WebDriver driver;
    public TestData testData = new TestData();

    String add_to_cart_basic = "//*[@id='add-to-cart-";
    String remove_basic = "//*[@id='remove-";
	
	public Base(WebDriver driver){
        this.driver = driver;
	}

    public void wait(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(By by){
        wait(by);
        driver.findElement(by).click();
    }

    public void sendText(By by, String s) {
        wait(by);
    	driver.findElement(by).sendKeys(s);
    }

    public boolean elementExist(By by){
        return driver.findElements(by).size() > 0;
    }

    public String getText(By by){
        wait(by);
        return driver.findElement(by).getText();
    }

    public List<String> getTextList(By by){
        wait(by);
        List<String> items = new ArrayList<String>();

        for(WebElement found : driver.findElements(by)){
            items.add(found.getText());
        }
        return items;
    }

    public String getItem(String item){
        return (item.equals(testData.item1) ? testData.item1 : testData.item2).
                toLowerCase().replace(' ', '-');
    }

    public String add_to_cart(String item){
        return add_to_cart_basic + getItem(item) + "']";
    }

    public String remove_from_cart(String item){
        return remove_basic + getItem(item) + "']";
    }
}

