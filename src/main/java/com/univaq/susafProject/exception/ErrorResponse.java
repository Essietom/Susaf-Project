package com.univaq.susafProject.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String responseCode;
    private String responseMessage;
}
