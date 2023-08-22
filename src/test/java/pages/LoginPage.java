package pages;

import com.google.common.base.Equivalence;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.util.Base64;

public class LoginPage extends Base{
    public LoginPage(WebDriver driver){
        super(driver);
    }
    
    private final By usernameInput = By.xpath("//*[@id='user-name']");
    private final By passwordInput = By.xpath("//*[@id='password']");
    private final By loginButton = By.xpath("//*[@id='login-button']");
    private final By productHeader = By.xpath("//*[@id='header_container']/div[2]/span");

    public String encryptPassword(){
        Base64.Encoder encoder = Base64.getMimeEncoder();
        return encoder.encodeToString(testData.password.getBytes());
    }
    public String decryptPassword(){
        Base64.Decoder decoder = Base64.getMimeDecoder();
        return new String(decoder.decode(testData.password.getBytes()));
    }

    public void login(){
    	sendText(usernameInput, testData.username);
    	sendText(passwordInput, decryptPassword());
        click(loginButton);

        Assert.assertEquals(getText(productHeader), "Products");
    }
}
