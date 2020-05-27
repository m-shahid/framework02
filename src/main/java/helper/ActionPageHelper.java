package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionPageHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public ActionPageHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    public void click(WebElement element){
        try{
            element.click();
        }catch(Exception e){
            System.out.println("Exception occurred while clicking on element");
        }
    }

    public void type(WebElement element, String text){
        try{
            element.sendKeys(text);
        }catch(Exception e){
            System.out.println("Exception occurred while typing text");
        }
    }

    public void waitForElementToBePresent(By locator){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch(Exception e){
            System.out.println("Exception occurred while waiting for element to be present");
        }
    }
}
