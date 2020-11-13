package com.airbnb.crud.exceptions;

import com.airbnb.crud.controller.model.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang3.exception.ExceptionUtils;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This reponse will be sent in case on un handled exception.
     * @param ex exception thrown by the service or controller
     * @return response of type @BaseResponse
     */
    @ExceptionHandler(Exception.class)
    protected @ResponseBody BaseResponse genericExceptionHandler(Exception ex) {
        AirbnbException exception = new AirbnbException(INTERNAL_SERVER_ERROR);
        String debugMessage = getDebugMessageFromStackTrace(ex);
        exception.setDebugMessage(debugMessage);
        exception.setMessage("There was an error in performing this operation.");
        return buildResponseEntity(exception);
    }
    private BaseResponse buildResponseEntity(AirbnbException exception) {
        return new BaseResponse(1, exception.getMessage(),null);
    }

    private String getDebugMessageFromStackTrace(Exception ex) {
        if (ex.getStackTrace() != null && ex.getStackTrace().length > 0) {
            ex.printStackTrace();
            String rootCause = ExceptionUtils.getRootCauseMessage(ex.getCause());
            String msg = "";
            if (!StringUtils.isEmpty(ex.getMessage())) {
                msg = ex.getMessage();
            }
            return msg + " at " + ex.getStackTrace()[0].getLineNumber()
                    + " in method " + ex.getStackTrace()[0].getMethodName()
                    + " in class " + ex.getStackTrace()[0].getClassName()
                    + "with rootCause " + rootCause;
        }
        return null;
    }
}
