package pages;

import logger.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SSOPage extends BasePage {

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[4]")
    private WebElement environmentDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[4]/li")
    private List<WebElement> environments;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[5]")
    private WebElement clientDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[5]/li")
    private List<WebElement> clients;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[6]")
    private WebElement programDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[6]/li")
    private List<WebElement> programs;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[7]")
    private WebElement sitesDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[7]/li")
    private List<WebElement> sites;

    @FindBy(xpath = "(//*[@class='btn dropdown-toggle selectpicker btn-default'])[8]")
    private WebElement cultureDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-menu inner selectpicker'])[8]/li")
    private List<WebElement> cultures;

    @FindBy(xpath = "(//*[@class='form-control ng-pristine ng-untouched ng-valid'])[1]")
    private WebElement pointBalanceTextBox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    private WebElement goButton;

    public HomePage loadSSOConfiguration(String environment, String client, String program, String site, String culture, String pointBalance) {
        return selectEnvironment(environment)
                .selectClient(client)
                .selectProgram(program)
                .selectSite(site)
                .selectCulture(culture)
                .typePointBalance(pointBalance)
                .submit();
    }

    private void findAndClickElement(List<WebElement> elements, String elementText){
        act.sleep(1000);
        for(WebElement element : elements){
            if(element.getText().contains(elementText)){
                act.click(element);
                break;
            }
        }
    }

    public SSOPage selectEnvironment(String environment){
        act.click(environmentDropDown);
        findAndClickElement(environments, environment);
        Logger.info("User has selected " + environment + " environment");
        return this;
    }

    public SSOPage selectClient(String client){
        act.click(clientDropDown);
        findAndClickElement(clients, client);
        Logger.info("User has selected " + client + " client");
        return this;
    }

    public SSOPage selectProgram(String program){
        act.click(programDropDown);
        findAndClickElement(programs, program);
        Logger.info("User has selected " + program + " program");
        return this;
    }

    public SSOPage selectSite(String site){
        act.click(sitesDropDown);
        findAndClickElement(sites, site);
        Logger.info("User has selected " + site + " site");
        return this;
    }

    public SSOPage selectCulture(String culture){
        act.click(cultureDropDown);
        findAndClickElement(cultures, culture);
        Logger.info("User has selected " + culture + " culture");
        return this;
    }

    public SSOPage typePointBalance(String pointBalanceValue){
        act.type(pointBalanceTextBox, pointBalanceValue);
        Logger.info("User has entered " + pointBalanceValue + " point balance");
        return this;
    }

    public HomePage submit(){
        act.click(goButton);
        Logger.info("User has clicked on go button");
        return PageFactoryProvider.getHomePage();
    }
}
