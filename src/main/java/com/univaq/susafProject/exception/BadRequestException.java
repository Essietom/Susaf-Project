package com.univaq.susafProject.exception;

public class BadRequestException extends ApplicationException {

    public BadRequestException(String code, String message) {
        super(code, message);
    }
}
