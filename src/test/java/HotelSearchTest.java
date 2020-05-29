import core.BaseTest;
import org.testng.annotations.Test;
import pages.PageFactoryProvider;

public class HotelSearchTest extends BaseTest {

    @Test
    public void HotelSearchForLASLocationTest(){

        PageFactoryProvider.getSSOPage()
                .loadSSOConfiguration("SG", "ORXeC Demo", "1371", "BaseResponsive", "English (United States)", "60000")
                .searchHotel("LAS", 90, 2)
                .isAtHotelSearchResultPage();
    }
}
