package com.jp.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.crudspring.model.Course;
import com.jp.crudspring.service.CourseService;

@RestController()
@RequestMapping("/api/courses")
public class CourseController {

    
    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public List<Course> list() {
        return courseService.getCourses();
    }

}
