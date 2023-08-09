package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Base {
	public WebDriver driver;
    protected Properties properties;
	
	public Base(WebDriver driver){
        this.driver = driver;
        readProperty();
	}

    public void readProperty(){
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Info.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            this.properties = prop;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        String val = driver.findElement(by).getText();
        return val;
    }
}
