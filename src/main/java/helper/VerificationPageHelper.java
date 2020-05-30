package helper;

import logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VerificationPageHelper {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public VerificationPageHelper(WebDriver driver, FluentWait<WebDriver> wait){
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
