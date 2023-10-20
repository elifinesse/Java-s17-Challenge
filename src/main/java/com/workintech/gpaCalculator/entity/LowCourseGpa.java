package com.workintech.gpaCalculator.entity;

import org.springframework.stereotype.Component;

import com.workintech.gpaCalculator.model.CourseGpa;

@Component
public class LowCourseGpa implements CourseGpa{

    @Override
    public int getGpa() {
        return 3;
    }
    
}
