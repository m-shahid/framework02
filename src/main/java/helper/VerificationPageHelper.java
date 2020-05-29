package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VerificationPageHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public VerificationPageHelper(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void pageTitle(String pageTitle){
        try{
            Assert.assertTrue(driver.getTitle().equalsIgnoreCase(pageTitle));
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }

    public void isAt(WebElement element){
        try{
            Assert.assertTrue(element.isDisplayed());
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }
}
