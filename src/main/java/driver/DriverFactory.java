package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver = null;

    private DriverFactory(){

    }

    public static WebDriver createInstance(String browserName, String target){

        if(driver != null)
            return driver;

        switch (target){
            case "local":
                driver = new LocalDriver().createInstance(browserName);
                break;

            /*TODO Need to implement RemoteDriver*/
//            case "grid":
//                driver = new RemoteDriver().createInstance(browserName);
//                break;
        }
        return driver;
    }
}
