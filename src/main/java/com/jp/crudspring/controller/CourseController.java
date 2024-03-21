package com.jp.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Course> save(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.saveCourse(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return courseService.findByid(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        //return ResponseEntity.ok(courseService.update(id, course));
        return courseService.findByid(id).map(recordFound -> {
            return ResponseEntity.ok(courseService.update(id, course));
        }).orElse(ResponseEntity.notFound().build());
    }
}
