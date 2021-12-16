package com.echavarria.survey.entities.dtos;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private Integer status;
    private String message;
    private String request;
    private String method;
    private String error;

    public ErrorResponse(LocalDateTime timestamp, Integer status, String message, String request, String method, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.request = request;
        this.method = method;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
