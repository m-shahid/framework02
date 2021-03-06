package pages;

import logger.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "#search-hotel-button")
    WebElement hotelSearchNavButton;

    @FindBy(css = "#inputDestination")
    WebElement destinationTextBox;

    @FindBy(xpath = "(//*[@class='autosuggest-item ui-menu-item ui-state-focus'])")
    WebElement destinationLocation;

    @FindBy(xpath = "//*[@class='datepicker-cmd datepicker-cmd-next ']")
    WebElement nextMonthIcon;

    @FindBy(xpath = "//*[contains(@class,'datepicker-state-default')]")
    List<WebElement> calenderDates;

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
        Logger.info("User has navigated to hotel search page.");
        return this;
    }

    public HomePage typeDestination(String destination) {
        act.type(destinationTextBox, destination);
        Logger.info("User has entered "+ destination +" destination.");
        return this;
    }

    public HomePage selectDestination() {
        act.click(destinationLocation);
        Logger.info("User has selected first destination from dropdown.");
        return this;
    }


    public HomePage calenderDatePicker(int daysFromToday, int duration) {
        act.click(checkInDateInputBox);
        String expectedCheckInDate = getDate(daysFromToday);
        String expectedCheckOutDate = getDate(daysFromToday + duration);
        selectCalenderDate(expectedCheckInDate);
        Logger.info("User has selected check in date as : " + expectedCheckInDate);
        selectCalenderDate(expectedCheckOutDate);
        Logger.info("User has selected check out date as : " + expectedCheckOutDate);
        //act.click(checkInDate);
        return this;
    }

    private void selectCalenderDate(String date){
        boolean isDateClicked = false;
        int dateCounter = 12;

        while(!isDateClicked && dateCounter > 0){
            for(WebElement calenderDate : calenderDates){
                if(calenderDate.getAttribute("title").contains(date)){
                    act.click(calenderDate);
                    isDateClicked = true;
                    break;
                }
            }
            if(isDateClicked)
                break;

            act.click(nextMonthIcon);
            dateCounter--;
        }
    }

    private String getDate(int daysFromToday){
        String pattern = "MMM dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Now use today date.
        calendar.add(Calendar.DATE, daysFromToday);
        String date = simpleDateFormat.format(calendar.getTime());
        System.out.println(date);
        return date;
    }

    public HotelSearchResultPage clickOnHotelSearchButton() {
        act.click(hotelSearchButton);
        Logger.info("User has clicked on hotel search button.");
        return PageFactoryProvider.getHotelSearchResultPage();
    }

    public HotelSearchResultPage searchHotel(String destination, int daysFromToday, int duration) {

        return navigateToHotel()
                .typeDestination(destination)
                .selectDestination()
                .calenderDatePicker(daysFromToday, duration)
                .clickOnHotelSearchButton();
    }

}
