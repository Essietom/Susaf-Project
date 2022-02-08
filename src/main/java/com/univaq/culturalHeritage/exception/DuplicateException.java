package com.univaq.culturalHeritage.exception;

public class DuplicateException extends ApplicationException {

    public DuplicateException(String code, String message) {
        super(code, message);
    }
}
