package com.workintech.gpaCalculator.entity;

import com.workintech.gpaCalculator.model.CourseGpa;

public class LowCourseGpa implements CourseGpa{

    @Override
    public int getGpa() {
        return 3;
    }
    
}
