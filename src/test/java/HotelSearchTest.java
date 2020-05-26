import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelSearchTest {

    WebDriver driver;

    @Test
    public void HotelSearchForLASLocationTest(){
        String currentUserDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentUserDirectory + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://cltsenvironments.loyaltytravelservices.com/SSOSimulator/");

        WebElement productDropDown = driver.findElement(By.xpath("(//*[@class=\\'btn dropdown-toggle selectpicker btn-default\\'])[2]"));
        WebElement templarSelectionDropDown = driver.findElement(By.xpath("(//*[@class='btn dropdown-toggle selectpicker btn-default'])[3]"));

        WebElement environmentDropDown = driver.findElement(By.xpath("(//*[@class='btn dropdown-toggle selectpicker btn-default'])[4]"));
        environmentDropDown.click();
        WebElement environment = driver.findElement(By.xpath("(//*[@class='dropdown-menu inner selectpicker'])[4]/li[2]"));
        environment.click();

        WebElement clientDropDown = driver.findElement(By.xpath("(//*[@class='btn dropdown-toggle selectpicker btn-default'])[5]"));
        clientDropDown.click();
        WebElement client = driver.findElement(By.xpath("(//*[@class='dropdown-menu inner selectpicker'])[5]//*[contains(text(),'ORXeC Demo')]"));
        client.click();

        WebElement programDropDown = driver.findElement(By.xpath("(//*[@class='btn dropdown-toggle selectpicker btn-default'])[6]"));
        programDropDown.click();
        WebElement program = driver.findElement(By.xpath("(//*[@class='dropdown-menu inner selectpicker'])[6]//*[contains(text(),'1371')]"));
        program.click();

        WebElement sitesDropDown = driver.findElement(By.xpath("(//*[@class='btn dropdown-toggle selectpicker btn-default'])[7]"));
        sitesDropDown.click();
        WebElement site = driver.findElement(By.xpath("((//*[@class='dropdown-menu inner selectpicker'])[7]//*[contains(text(),'BaseResponsive')])[1]"));
        site.click();

        WebElement cultureDropDown = driver.findElement(By.xpath("(//*[@class='btn dropdown-toggle selectpicker btn-default'])[8]"));
        cultureDropDown.click();
        WebElement culture = driver.findElement(By.xpath("(//*[@class='dropdown-menu inner selectpicker'])[8]//*[contains(text(),'English (United States)')]"));
        culture.click();

        WebElement pointBalanceTextBox = driver.findElement(By.xpath("(//*[@class='form-control ng-pristine ng-untouched ng-valid'])[1]"));
        pointBalanceTextBox.sendKeys("600000");
        WebElement goButton = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        goButton.click();
    }
}
