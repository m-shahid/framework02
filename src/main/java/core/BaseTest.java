package core;

import config.ConfigurationManager;
import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
        WebDriver driver = DriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);
        //DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(ConfigurationManager.getAppConfig().getApplicationBaseUrl());
    }

    @AfterMethod
    public void cleanup(){
        DriverManager.quit();
    }
}
