package com.univaq.culturalHeritage.exception;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String code, String message) {
        super(code, message);
    }
}