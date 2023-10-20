package com.workintech.gpaCalculator.dto;

import com.workintech.gpaCalculator.model.Course;
import com.workintech.gpaCalculator.model.CourseGpa;


public class CourseResponseFactory {
    
    public static CourseResponse createCourseResponse(Course course, CourseGpa low, CourseGpa medium, CourseGpa high){
        if(course.getCredit() <= 2){
            return new CourseResponse(course, course.getGrade().getCoefficient() * course.getCredit() * low.getGpa());
        } else if(course.getCredit() == 3){
            return new CourseResponse(course, course.getGrade().getCoefficient() * course.getCredit() * medium.getGpa());
        } else if(course.getCredit() == 4){
            return new CourseResponse(course, course.getGrade().getCoefficient() * course.getCredit() * high.getGpa());
        }
        return null;
    }
}
