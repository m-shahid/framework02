import core.BaseTest;
import org.testng.annotations.Test;
import pages.PageFactoryProvider;

public class HotelSearchTest extends BaseTest {

    @Test
    public void HotelSearchForLASLocationTest(){

        PageFactoryProvider.getSSOPage()
                .loadSSOConfiguration()
                .searchHotel()
                .isAtHotelSearchResultPage();
    }
}
