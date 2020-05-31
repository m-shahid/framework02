package logger;

import config.ConfigurationManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import report.AllureReportManager;

public class Logger {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Logger.class);

    @Step("{0}")
    public static void info(String message) {
        if(!ConfigurationManager.getAppConfig().getOnlyFailedTestScreenshot())
            AllureReportManager.takeAndAttachScreenshot();
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    @Step("{0}")
    public static void error(String message) {
        AllureReportManager.takeAndAttachScreenshot();
        log.error(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }

    @Step("{0}")
    public static void debug(String message) {
        log.debug(message);
    }
}
