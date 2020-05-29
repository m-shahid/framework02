package core;

import config.ConfigurationManager;
import driver.DriverFactory;
import driver.DriverManager;
import logger.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(String browser){
        Logger.info("=========================================================");
        Logger.info("Starting new test...");
        Logger.info("Creating driver using " + browser + " browser");
        WebDriver driver = DriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(ConfigurationManager.getAppConfig().getApplicationBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        Logger.info("Closing browser instance.");
        DriverManager.close();
    }

}
