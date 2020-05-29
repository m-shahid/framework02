package pages;

import driver.DriverManager;
import helper.ActionPageHelper;
import helper.VerificationPageHelper;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected ActionPageHelper act;
    protected VerificationPageHelper verify;
    private WebDriverWait wait;

    public BasePage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), 20), this);
        wait = new WebDriverWait(DriverManager.getDriver(), 20);
        act = new ActionPageHelper(DriverManager.getDriver(), wait);
        verify = new VerificationPageHelper(DriverManager.getDriver(), wait);
    }
}
