import core.BaseTest;
import org.testng.annotations.Test;
import pages.PageFactoryProvider;

public class HotelRoomSearchTest extends BaseTest {

    @Test
    public void HotelSearchForSFOLocationTest(){

        PageFactoryProvider.getSSOPage()
                .loadSSOConfiguration("SG", "ORXeC Demo", "1371", "BaseResponsive", "English (United States)", "60000")
                .searchHotel("SFO", 90, 2)
                .isAtHotelSearchResultPage();
    }
}
