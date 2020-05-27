package core;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeSuite
    public void setup(){
        WebDriver driver = DriverFactory.createInstance("chrome", "local");
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get("http://cltsenvironments.loyaltytravelservices.com/SSOSimulator/");
    }

    @AfterSuite
    public void cleanup(){
        DriverManager.close();
    }
}
