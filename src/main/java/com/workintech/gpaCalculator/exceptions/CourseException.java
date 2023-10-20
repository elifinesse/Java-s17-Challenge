package com.workintech.gpaCalculator.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CourseException extends RuntimeException{
    private HttpStatus httpStatus;

    public CourseException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
    
}
