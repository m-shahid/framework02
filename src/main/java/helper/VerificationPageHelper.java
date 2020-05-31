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
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(pageTitle));
    }

    public void isAt(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }
}
