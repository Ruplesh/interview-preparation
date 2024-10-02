package com.example.interviewpreparation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Handle exception and return JSON response
        return new ResponseEntity<>("Inside Global exception Handler: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
