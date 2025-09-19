package com.SIH.KrishiSetu.KrishiSetu.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}