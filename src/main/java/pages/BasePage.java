package pages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), 20), this);
    }
}
