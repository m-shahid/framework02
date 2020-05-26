import core.BaseTest;
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

public class HotelSearchTest extends BaseTest {

    @Test
    public void HotelSearchForLASLocationTest(){

        SSOPage ssoPage = new SSOPage(driver);
        ssoPage.loadSSOConfiguration();

        HomePage homePage = new HomePage(driver);
        homePage.searchHotel();

        HotelSearchResultPage hotelSearchResultPage = new HotelSearchResultPage(driver);
        hotelSearchResultPage.isAt();
    }
}
