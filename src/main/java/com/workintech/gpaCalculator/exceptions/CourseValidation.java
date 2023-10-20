package com.workintech.gpaCalculator.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.workintech.gpaCalculator.model.Course;

public class CourseValidation {
    
    public static void isIdValid(int id){
        if(id < 0){
            throw new CourseException("Id must be a positive integer.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isCourseNameUsed(List<Course> courses, String name){
        for(Course course: courses){
            if(course.getName().equalsIgnoreCase(name)){
                throw new CourseException("A course with this name already exists.", HttpStatus.BAD_REQUEST);
            }
        }
    }

    public static void isCourseValid(Course course){
        if(course.getCredit() < 1 || course.getCredit() > 4 || course.getName().isEmpty() || course.getName() == null){
            throw new CourseException("The information given for this course is not valid.", HttpStatus.BAD_REQUEST);
        }
    }
}
