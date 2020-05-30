package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

public class ActionPageHelper {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public ActionPageHelper(WebDriver driver, FluentWait<WebDriver> wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void click(WebElement element){
        try{
            waitForElementToBeClickable(element);
            element.click();
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }

    public String getText(WebElement element){
        try{
            return element.getText();
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }

    public void type(WebElement element, String text){
        try{
            element.sendKeys(text);
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }

    public void waitForElementToBePresent(By locator){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }

    public void waitForElementToBeClickable(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }

    public void waitForAllElementsToBeVisible(List<WebElement> elements){
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        }catch(Exception e){
            throw new ElementException(e.getMessage());
        }
    }

    public void sleep(int timeoutInMilliSecond){
        try{
            Thread.sleep(timeoutInMilliSecond);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
