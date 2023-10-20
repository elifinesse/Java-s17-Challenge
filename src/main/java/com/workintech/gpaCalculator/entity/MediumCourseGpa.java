package com.workintech.gpaCalculator.entity;

import com.workintech.gpaCalculator.model.CourseGpa;

public class MediumCourseGpa implements CourseGpa{

    @Override
    public int getGpa() {
        return 5;
    }
    
}
