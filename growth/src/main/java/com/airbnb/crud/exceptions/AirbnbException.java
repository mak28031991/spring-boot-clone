package com.airbnb.crud.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class AirbnbException extends Throwable{
    private HttpStatus status;
    private String message;
    private String debugMessage;

    public AirbnbException(HttpStatus status) {
        this.status = status;
    }

    public AirbnbException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public AirbnbException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public AirbnbException(Throwable cause, HttpStatus status) {
        super(cause);
        this.status = status;
    }

    public AirbnbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }
}
