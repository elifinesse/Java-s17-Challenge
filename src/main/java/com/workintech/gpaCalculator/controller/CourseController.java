package com.workintech.gpaCalculator.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.gpaCalculator.dto.CourseResponse;
import com.workintech.gpaCalculator.dto.CourseResponseFactory;
import com.workintech.gpaCalculator.exceptions.CourseErrorResponse;
import com.workintech.gpaCalculator.exceptions.CourseException;
import com.workintech.gpaCalculator.exceptions.CourseValidation;
import com.workintech.gpaCalculator.model.Course;
import com.workintech.gpaCalculator.model.CourseGpa;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private List<Course> courses;
    private CourseGpa lowCourseGpa;
    private CourseGpa mediumCourseGpa;
    private CourseGpa highCourseGpa;


    @PostConstruct
    public void init(){
        courses = new ArrayList<>();
    }

    @Autowired
    public CourseController(@Qualifier("lowCourseGpa") CourseGpa lowCourseGpa, @Qualifier("mediumCourseGpa") CourseGpa mediumCourseGpa, @Qualifier("highCourseGpa") CourseGpa highCourseGpa){
        this.lowCourseGpa = lowCourseGpa;
        this.mediumCourseGpa = mediumCourseGpa;
        this.highCourseGpa = highCourseGpa;
    }

    @GetMapping("/")
    public List<Course> listCourses(){
        return courses;
    }

    @GetMapping("/{name}")
    public Course getCourse(@PathVariable String name){
        for(Course course: courses){
            if(name.equalsIgnoreCase(course.getName())){
                return course;
            } 
        }
        throw new CourseException("A course with this name (" + name + ") does not exist.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public CourseResponse postCourse(@RequestBody Course course){
        CourseValidation.isIdValid(course.getId());
        CourseValidation.isCourseValid(course);
        CourseValidation.isCourseNameUsed(courses, course.getName());
        courses.add(course);
        return CourseResponseFactory.createCourseResponse(course, lowCourseGpa, mediumCourseGpa, highCourseGpa);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable int id){
        CourseValidation.isIdValid(id);
        CourseValidation.isCourseValid(course);
        CourseValidation.isCourseNameUsed(courses, course.getName());
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getId() == id){
                courses.set(i, course);
                return course;
            }
        }
        throw new CourseException("A course with this id (" + id + ") does not exist.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public Course deletCourse(@PathVariable int id){
        Iterator iterator = courses.iterator();
        while(iterator.hasNext()){
            Course course = (Course) iterator.next();
            if(course.getId() == id){
                iterator.remove();
                return course;
            }
        }
        throw new CourseException("A course with this id (" + id + ") does not exist.", HttpStatus.NOT_FOUND);
    }
    
}
