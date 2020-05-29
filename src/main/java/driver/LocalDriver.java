package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriver implements IDriver {

    @Override
    public WebDriver createInstance(String browserName) {
        String currentUserDirectory = System.getProperty("user.dir");
        switch (browserName){
            case "chrome":

                System.setProperty("webdriver.chrome.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                return new ChromeDriver();

            case "firefox":

                System.setProperty("webdriver.gecko.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\geckodriver.exe");
                return new FirefoxDriver();

            default:
                System.out.println("browser name not valid");
                return null;
        }
    }
}
