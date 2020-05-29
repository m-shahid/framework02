package pages;


public class PageFactoryProvider {

    private static SSOPage ssoPage;
    private static HomePage homePage;
    private static HotelSearchResultPage hotelSearchResultPage;

    private PageFactoryProvider(){
    }

    public static SSOPage getSSOPage(){
        PageManager.setSSOPage(new SSOPage());
        return PageManager.getSSOPage();
    }

    public static HomePage getHomePage(){
        PageManager.setHomePage(new HomePage());
        return PageManager.getHomePage();
    }

    public static HotelSearchResultPage getHotelSearchResultPage(){
        PageManager.setHotelSearchResultPage(new HotelSearchResultPage());
        return PageManager.getHotelSearchResultPage();
    }

}
