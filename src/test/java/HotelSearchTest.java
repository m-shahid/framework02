import core.BaseTest;
import org.testng.annotations.Test;
import pages.PageFactoryProvider;

public class HotelSearchTest extends BaseTest {

    @Test
    public void HotelSearchForLASLocationTest(){

        PageFactoryProvider.getSSOPage()
                .loadSSOConfiguration()
                .searchHotel("LAS", 90, 2)
                .isAtHotelSearchResultPage();
    }

    @Test
    public void HotelSearchForSFOLocationTest(){

        PageFactoryProvider.getSSOPage()
                .loadSSOConfiguration()
                .searchHotel("SFO", 90, 2)
                .isAtHotelSearchResultPage();
    }

}
