package pages;

import logger.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HotelSearchResultPage extends BasePage {

    @FindBy(xpath = "(//*[contains(@id,'ChooseRoom')])['1']")
    WebElement chooseRoomButton;

    public void isAtHotelSearchResultPage(){
        verify.isAt(chooseRoomButton);
        Logger.info("Hotel search result page is displayed.");
    }
}
