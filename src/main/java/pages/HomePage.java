package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "#search-hotel-button")
    WebElement hotelSearchNavButton;

    @FindBy(css = "#inputDestination")
    WebElement destinationTextBox;

    @FindBy(xpath = "(//*[@class='autosuggest-item ui-menu-item'])['1']")
    WebElement destinationLocation;

    @FindBy(css = "#inputCheckInDate")
    WebElement checkInDateInputBox;

    @FindBy(xpath = "//a[contains(@id,'28')]")
    WebElement checkInDate;

    @FindBy(css = "#inputCheckOutDate")
    WebElement checkOutDateInputBox;

    @FindBy(xpath = "//a[contains(@id,'29')]")
    WebElement checkOutDate;

    @FindBy(css = "#hotelSearchButton")
    WebElement hotelSearchButton;

    public HomePage navigateToHotel() {
        act.click(hotelSearchNavButton);
        return this;
    }

    public HomePage typeDestination() {
        act.type(destinationTextBox, "LAS");
        return this;
    }

    public HomePage selectDestination() {
        act.click(destinationLocation);
        return this;
    }


    public HomePage selectCheckInDate() {
        act.click(checkInDateInputBox);
        act.click(checkInDate);
        return this;
    }

    public HomePage selectCheckOutDate() {
        act.click(checkOutDateInputBox);
        act.click(checkOutDate);
        return this;
    }

    public HotelSearchResultPage clickOnHotelSearchButton() {
        act.click(hotelSearchButton);
        return PageFactoryProvider.getHotelSearchResultPage();
    }

    public HotelSearchResultPage searchHotel() {

        return navigateToHotel()
                .typeDestination()
                .selectDestination()
                .selectCheckInDate()
                .selectCheckOutDate()
                .clickOnHotelSearchButton();
    }

}
