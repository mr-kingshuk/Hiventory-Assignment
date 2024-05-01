package com.store.Store.errors;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {
    private HttpStatus status;

    private LocalDateTime timestamp;
    private String message;

    //Constructors
    public ErrorResponse(HttpStatus status, LocalDateTime timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    public ErrorResponse(HttpStatus status){
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, String message){
        this();
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(){
        timestamp = LocalDateTime.now();
    }

    //Getters and Setter class
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
