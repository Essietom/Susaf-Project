package com.univaq.culturalHeritage.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice

public class ApiAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setResponseCode(ex.getCode());
        response.setResponseMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}