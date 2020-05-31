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
        waitForElementToBeClickable(element);
        element.click();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public void waitForElementToBePresent(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAllElementsToBeVisible(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void sleep(int timeoutInMilliSecond){
        try{
            Thread.sleep(timeoutInMilliSecond);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
