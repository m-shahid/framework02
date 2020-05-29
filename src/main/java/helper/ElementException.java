package helper;

import logger.Logger;

public class ElementException extends RuntimeException {

    public ElementException(String errorMessage){
        super(errorMessage);
        Logger.error(getMessage());
    }

}
