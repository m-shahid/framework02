package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSOPage {

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[4]")
    private WebElement environmentDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[4]/li[2]")
    private WebElement environment;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[5]")
    private WebElement clientDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[5]//*[contains(text(),'ORXeC Demo')]")
    private WebElement client;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[6]")
    private WebElement programDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[6]//*[contains(text(),'1371')]")
    private WebElement program;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[7]")
    private WebElement sitesDropDown;

    @FindBy(xpath = "((//*[@class='dropdown-menu inner selectpicker'])[7]//*[contains(text(),'BaseResponsive')])[1]")
    private WebElement site;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[8]")
    private WebElement cultureDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[8]//*[contains(text(),'English (United States)')]")
    private WebElement culture;

    @FindBy(xpath = "(//*[@class='form-control ng-pristine ng-untouched ng-valid'])[1]")
    private WebElement pointBalanceTextBox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    private WebElement goButton;

    public SSOPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void loadSSOConfiguration() {
        environmentDropDown.click();
        environment.click();
        clientDropDown.click();
        client.click();
        programDropDown.click();
        program.click();
        sitesDropDown.click();
        site.click();
        cultureDropDown.click();
        culture.click();
        pointBalanceTextBox.sendKeys("600000");
        goButton.click();
    }
}
