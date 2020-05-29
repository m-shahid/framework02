package driver;

import logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriver implements IDriver {

    @Override
    public WebDriver createInstance(String browserName) {
        String currentUserDirectory = System.getProperty("user.dir");
        switch (browserName){
            case "chrome":
                Logger.info("Creating local chrome driver");
                System.setProperty("webdriver.chrome.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                return new ChromeDriver();

            case "firefox":
                Logger.info("Creating local firefox driver");
                System.setProperty("webdriver.gecko.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\geckodriver.exe");
                return new FirefoxDriver();

            default:
                System.out.println("browser name not valid");
                return null;
        }
    }
}
