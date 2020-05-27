package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalDriver implements IDriver {

    @Override
    public WebDriver createInstance(String browserName) {
        switch (browserName){
            case "chrome":
                String currentUserDirectory = System.getProperty("user.dir");
                System.setProperty("webdriver.chrome.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                return new ChromeDriver();

            default:
                System.out.println("browser name not valid");
                return null;
        }
    }
}
