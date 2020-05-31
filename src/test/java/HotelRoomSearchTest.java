import core.BaseTest;
import org.testng.annotations.Test;
import pages.PageFactoryProvider;

public class HotelRoomSearchTest extends BaseTest {

    @Test
    public void HotelSearchForSFOLocationTest(){

        PageFactoryProvider.getSSOPage()
                .loadSSOConfiguration()
                .searchHotel("SFO", 90, 2)
                .isAtHotelSearchResultPage();
    }
}
