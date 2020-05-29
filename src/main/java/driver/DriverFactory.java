package driver;

import config.ConfigurationManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver = null;

    private DriverFactory(){

    }

    public static WebDriver createInstance(String browserName){

        String target = ConfigurationManager.getAppConfig().getTarget();

        if(driver != null)
            return driver;

        switch (target){
            case "local":
                driver = new LocalDriver().createInstance(browserName);
                break;

            case "remote":
                driver = new RemoteDriver().createInstance(browserName);
                break;
        }
        return driver;
    }
}
