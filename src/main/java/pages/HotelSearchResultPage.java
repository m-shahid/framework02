package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HotelSearchResultPage {

    @FindBy(xpath = "(//*[contains(@id,'ChooseRoom')])['1']")
    WebElement chooseRoomButton;

    public HotelSearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void isAt(){
        Assert.assertTrue(chooseRoomButton.isDisplayed());
    }
}
