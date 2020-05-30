package report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import config.AppConfig;
import config.ConfigurationManager;
import config.IConfiguration;
import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureReportManager {

    private AllureReportManager(){

    }

    public static void setEnvironmentInfo() {
        AppConfig configuration = ConfigurationManager.getAppConfig();

        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().
                        put("URL", configuration.getApplicationBaseUrl()).
                        put("Target", configuration.getTarget()).
                        build());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeAndAttachScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Browser information", type = "text/plain")
    public static String getAndAttachBrowserInfo() {
        return DriverManager.getInfo();
    }

}
