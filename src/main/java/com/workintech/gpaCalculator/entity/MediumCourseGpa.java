package com.workintech.gpaCalculator.entity;

import org.springframework.stereotype.Component;

import com.workintech.gpaCalculator.model.CourseGpa;

@Component
public class MediumCourseGpa implements CourseGpa{

    @Override
    public int getGpa() {
        return 5;
    }
    
}
