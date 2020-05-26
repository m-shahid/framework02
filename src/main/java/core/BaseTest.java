package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void setup(){
        String currentUserDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://cltsenvironments.loyaltytravelservices.com/SSOSimulator/");
    }

    @AfterSuite
    public void cleanup(){
        driver.close();
    }
}
