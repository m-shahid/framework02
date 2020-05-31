package driver;

import config.ConfigurationManager;
import config.IConfiguration;
import helper.DriverException;
import logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteDriver implements IDriver {

    @Override
    public WebDriver createInstance(String browser) {
        IConfiguration configuration = ConfigurationManager.getConfiguration();
        RemoteWebDriver driver = null;
        try{
            String gridUrl = String.format("http://%s:%s/wd/hub", configuration.getGridUrl(), configuration.getGridPort());
            driver = new RemoteWebDriver(new URL(gridUrl), getCapabilities(browser));
        }catch(Exception e){
            throw new DriverException(e.getMessage());
        }
        return driver;
    }

    private DesiredCapabilities getCapabilities(String browser){

        switch (browser.toLowerCase()){
            case "chrome":
                Logger.debug("Creating remote chrome driver");
                return DesiredCapabilities.chrome();

            case "firefox":
                Logger.debug("Creating remote firefox driver");
                return DesiredCapabilities.firefox();
        }
        throw new DriverException("Can not get capabilities since browser name not valid");
    }
}
