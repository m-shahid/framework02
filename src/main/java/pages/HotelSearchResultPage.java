package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HotelSearchResultPage extends BasePage {

    private static HotelSearchResultPage hotelSearchResultPage;

    @FindBy(xpath = "(//*[contains(@id,'ChooseRoom')])['1']")
    WebElement chooseRoomButton;

    private HotelSearchResultPage(){
    }

    public static HotelSearchResultPage getInstance(){
        if(hotelSearchResultPage == null){
            hotelSearchResultPage = new HotelSearchResultPage();
        }
        return hotelSearchResultPage;
    }

    public void isAtHotelSearchResultPage(){
        Assert.assertTrue(chooseRoomButton.isDisplayed());
    }
}
