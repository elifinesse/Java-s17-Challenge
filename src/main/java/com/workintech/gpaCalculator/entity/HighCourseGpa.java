package com.workintech.gpaCalculator.entity;

import com.workintech.gpaCalculator.model.CourseGpa;

public class HighCourseGpa implements CourseGpa{

    @Override
    public int getGpa() {
        return 10;
    }
    
}
