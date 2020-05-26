package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
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

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void searchHotel() {
        hotelSearchNavButton.click();
        destinationTextBox.sendKeys("LAS");
        destinationLocation.click();
        checkInDateInputBox.click();
        checkInDate.click();
        checkOutDateInputBox.click();
        checkOutDate.click();
        hotelSearchButton.click();
    }
}
