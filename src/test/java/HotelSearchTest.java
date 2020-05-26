import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelSearchResultPage;
import pages.SSOPage;

import java.util.concurrent.TimeUnit;

public class HotelSearchTest {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void HotelSearchForLASLocationTest(){
        String currentUserDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://cltsenvironments.loyaltytravelservices.com/SSOSimulator/");

        SSOPage ssoPage = new SSOPage(driver);
        ssoPage.loadSSOConfiguration();

        HomePage homePage = new HomePage(driver);
        homePage.searchHotel();
        
        HotelSearchResultPage hotelSearchResultPage = new HotelSearchResultPage(driver);
        hotelSearchResultPage.isAt();

        driver.close();
    }
}
