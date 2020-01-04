package com.lobuz.core.cod.exception;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

public class ErrorDetails {

    private int code;
    private String message;
    private String description;
    private HttpStatus status;
    private String timestamp;

    public ErrorDetails(int code, String message, String description, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.status = status;
        this.timestamp = OffsetDateTime.now().toString();
    }

    public ErrorDetails() {
    }

    @JsonDeserialize(as = HttpStatus.class)
    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
