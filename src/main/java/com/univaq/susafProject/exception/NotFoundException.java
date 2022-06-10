package com.univaq.susafProject.exception;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String code, String message) {
        super(code, message);
    }
}