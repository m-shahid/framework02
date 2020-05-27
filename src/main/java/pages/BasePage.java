package pages;

import driver.DriverManager;
import helper.ActionPageHelper;
import helper.VerificationPageHelper;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {

    protected ActionPageHelper act;
    protected VerificationPageHelper verify;

    public BasePage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), 20), this);
        act = new ActionPageHelper(DriverManager.getDriver());
        verify = new VerificationPageHelper(DriverManager.getDriver());
    }
}
