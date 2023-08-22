package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.TestData;

public class BaseTest{
    WebDriver driver;
    public TestData testData = new TestData();
    
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/../chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testData.website);
        this.driver = driver;
    }
}
