package com.jp.crudspring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.jp.crudspring.model.Course;
import com.jp.crudspring.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {

    
    private final CourseRepository courseRepository;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Transactional()
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

}
