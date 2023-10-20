package com.workintech.gpaCalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Course {
    private int id;
    private String name;
    private int credit;
    private Grade grade;
}
