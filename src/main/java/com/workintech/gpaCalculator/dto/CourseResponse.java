package com.workintech.gpaCalculator.dto;

import com.workintech.gpaCalculator.model.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    
    private Course course;
    private double totalGpa;
}
