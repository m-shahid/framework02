package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerificationPageHelper {

    private WebDriver driver;

    public VerificationPageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void pageTitle(String pageTitle){
        try{
            Assert.assertTrue(driver.getTitle().equalsIgnoreCase(pageTitle));
        }catch(Exception e){
            System.out.println("Exception occurred while verifying page title");
        }
    }

    public void isAt(WebElement element){
        try{
            Assert.assertTrue(element.isDisplayed());
        }catch(Exception e){
            System.out.println("Exception occurred while verifying page isAt");
        }
    }
}
