package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TestData{
    public TestData(){
        readProperty();
    }

    public String website;
    public String username;
    public String password;
    public String item1;
    public String item2;

    public void readProperty(){
        try (InputStream input = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//java//resources//Info.properties")
        ) {
            Properties prop = new Properties();
            prop.load(input);
            setProperties(prop);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setProperties(Properties prop){
        this.website = prop.getProperty("website");
        this.username = prop.getProperty("username");
        this.password = prop.getProperty("password");
        this.item1 = prop.getProperty("item1");
        this.item2 = prop.getProperty("item2");
    }
}