package com.univaq.culturalHeritage.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String responseCode;
    private String responseMessage;
}
