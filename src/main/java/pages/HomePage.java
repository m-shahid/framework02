package pages;

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
        return this;
    }

    public HomePage typeDestination(String destination) {
        act.type(destinationTextBox, destination);
        return this;
    }

    public HomePage selectDestination() {
        act.click(destinationLocation);
        return this;
    }


    public HomePage calenderDatePicker(int daysFromToday, int duration) {
        act.click(checkInDateInputBox);
        String expectedCheckInDate = getDate(daysFromToday);
        String expectedCheckOutDate = getDate(daysFromToday + duration);
        selectCalenderDate(expectedCheckInDate);
        selectCalenderDate(expectedCheckOutDate);
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

    public HomePage selectCheckOutDate() {
        act.click(checkOutDateInputBox);
        act.click(checkOutDate);
        return this;
    }

    public HotelSearchResultPage clickOnHotelSearchButton() {
        act.click(hotelSearchButton);
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
