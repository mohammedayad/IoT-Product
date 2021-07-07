package com.voice.iot.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IotDeviceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final HttpStatus statusCode;
    private final String errorMessage;

    public IotDeviceException(HttpStatus httpStatus, String errorMessage){
        super(errorMessage);
        this.statusCode = httpStatus;
        this.errorMessage = errorMessage;

    }
}
