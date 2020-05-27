package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SSOPage extends BasePage {

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

    public HomePage loadSSOConfiguration() {
        return selectEnvironment()
                .selectClient()
                .selectProgram()
                .selectSite()
                .selectCulture()
                .typePointBalance("600000")
                .submit();
    }

    public SSOPage selectEnvironment(){
        act.click(environmentDropDown);
        act.click(environment);
        return this;
    }

    public SSOPage selectClient(){
        act.click(clientDropDown);
        act.click(client);
        return this;
    }

    public SSOPage selectProgram(){
        act.click(programDropDown);
        act.click(program);
        return this;
    }

    public SSOPage selectSite(){
        act.click(sitesDropDown);
        act.click(site);
        return this;
    }

    public SSOPage selectCulture(){
        act.click(cultureDropDown);
        act.click(culture);
        return this;
    }

    public SSOPage typePointBalance(String pointBalanceValue){
        act.type(pointBalanceTextBox, pointBalanceValue);
        act.click(culture);
        return this;
    }

    public HomePage submit(){
        act.click(goButton);
        return PageFactoryProvider.getHomePage();
    }
}
