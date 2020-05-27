package pages;

import java.util.concurrent.ExecutionException;

public class PageFactoryProvider {

    private static SSOPage ssoPage;
    private static HomePage homePage;
    private static HotelSearchResultPage hotelSearchResultPage;

    private PageFactoryProvider(){
    }

    public static SSOPage getSSOPage(){
        if(ssoPage == null){
            ssoPage = new SSOPage();
        }
        return ssoPage;
    }

    public static HomePage getHomePage(){
        if(homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public static HotelSearchResultPage getHotelSearchResultPage(){
        if(hotelSearchResultPage == null){
            hotelSearchResultPage = new HotelSearchResultPage();
        }
        return hotelSearchResultPage;
    }

}
