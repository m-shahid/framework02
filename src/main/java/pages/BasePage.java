package pages;

import driver.DriverManager;
import helper.ActionPageHelper;
import helper.VerificationPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected ActionPageHelper act;
    protected VerificationPageHelper verify;

    public BasePage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), 30), this);
        //wait = new WebDriverWait(DriverManager.getDriver(), 20);
        //private WebDriverWait wait;
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        act = new ActionPageHelper(DriverManager.getDriver(), fluentWait);
        verify = new VerificationPageHelper(DriverManager.getDriver(), fluentWait);
    }
}
