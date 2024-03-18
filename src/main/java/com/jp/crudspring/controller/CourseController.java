package com.jp.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody List<Course> list() {
        return courseService.getCourses();
    }

    @PostMapping
    public @ResponseBody Course save(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
}
