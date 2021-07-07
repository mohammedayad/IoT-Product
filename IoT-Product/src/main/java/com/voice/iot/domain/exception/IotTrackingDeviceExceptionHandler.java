package com.voice.iot.domain.exception;

import com.voice.iot.model.ProblemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice(basePackages = "com.voice.iot.resources.rest.controller")
public class IotTrackingDeviceExceptionHandler {

    @ExceptionHandler(IotDeviceException.class)
    public ResponseEntity<Object> handleException(IotDeviceException exception) {

        log.error("IotTrackingDevice Exception with cause : {}", exception.getErrorMessage());
        ProblemDto problem = new ProblemDto();
        problem.setStatus(exception.getStatusCode().value());
        problem.setInstance(exception.getStatusCode().getReasonPhrase());
        problem.setType(exception.getStatusCode().getReasonPhrase());
        problem.setDetail(exception.getErrorMessage());
        problem.setTitle("Iot Tracking Device Error");

        return ResponseEntity.status(exception.getStatusCode()).body(problem);
    }
}
