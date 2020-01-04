package com.lobuz.core.cod.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class CoreException extends RuntimeException {

    private final ErrorDetails errorDetails;

    public CoreException(int code, String message, String description, HttpStatus status) {
        this.errorDetails = new ErrorDetails(code, message, description, status);
    }

    protected CoreException(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }

    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public static CoreException internalServerError(String msg) {
        return new CoreException(INTERNAL_SERVER_ERROR.value(), "INTERNAL_SERVER_ERROR", msg, INTERNAL_SERVER_ERROR);
    }
}
