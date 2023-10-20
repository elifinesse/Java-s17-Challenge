package com.workintech.gpaCalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<CourseErrorResponse> handleException(CourseException exception){
        CourseErrorResponse response = new CourseErrorResponse(exception.getHttpStatus().value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CourseErrorResponse> handleException(Exception exception){
        CourseErrorResponse response = new CourseErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
