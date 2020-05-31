package helper;

import logger.Logger;

public class DriverException extends RuntimeException {
    public DriverException(String errorMessage){
        super(errorMessage);
        Logger.fatal(getMessage());
    }
}
