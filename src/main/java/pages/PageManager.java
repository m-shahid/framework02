package pages;


public class PageManager {

    private static final ThreadLocal<SSOPage> ssoPage = new ThreadLocal<>();
    private static final ThreadLocal<HomePage> homePage = new ThreadLocal<>();
    private static final ThreadLocal<HotelSearchResultPage> hotelSearchResultPage = new ThreadLocal<>();

    private PageManager() {}

    public static SSOPage getSSOPage() {
        return ssoPage.get();
    }

    public static void setSSOPage(SSOPage page) {
        PageManager.ssoPage.set(page);
    }

    public static HomePage getHomePage() {
        return homePage.get();
    }

    public static void setHomePage(HomePage page) {
        PageManager.homePage.set(page);
    }

    public static HotelSearchResultPage getHotelSearchResultPage() {
        return hotelSearchResultPage.get();
    }

    public static void setHotelSearchResultPage(HotelSearchResultPage page) {
        PageManager.hotelSearchResultPage.set(page);
    }

    public static void remove() {
        ssoPage.remove();
    }

}
