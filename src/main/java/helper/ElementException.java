package helper;

import logger.Logger;
import report.AllureReportManager;

public class ElementException extends RuntimeException {

    public ElementException(String errorMessage){
        super(errorMessage);
        Logger.error(getMessage());
        AllureReportManager.takeAndAttachScreenshot();
    }

}
