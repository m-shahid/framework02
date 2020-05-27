package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryProvider {

    public static SSOPage getSSOPage(){
        return SSOPage.getInstance();
    }

    public static HomePage getHomePage(){
        return HomePage.getInstance();
    }

    public static HotelSearchResultPage getHotelSearchResultPage(){
        return HotelSearchResultPage.getInstance();
    }

}
