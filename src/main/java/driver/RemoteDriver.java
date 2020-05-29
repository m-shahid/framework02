package driver;

import config.ConfigurationManager;
import config.IConfiguration;
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
            e.printStackTrace();
        }
        return driver;
    }

    private DesiredCapabilities getCapabilities(String browser){

        switch (browser.toLowerCase()){
            case "chrome":
                return DesiredCapabilities.chrome();

            case "firefox":
                return DesiredCapabilities.firefox();
        }
        return null;
    }
}
