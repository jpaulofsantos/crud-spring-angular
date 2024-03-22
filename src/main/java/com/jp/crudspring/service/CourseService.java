package com.jp.crudspring.service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Transactional
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public Optional<Course> findByid(Long id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public Course update(Long id, Course course) {
        try {
            Course courseNovo = courseRepository.getReferenceById(id);
            courseNovo.setName(course.getName());
            courseNovo.setCategory(course.getCategory());

            return courseRepository.save(courseNovo);

        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Transactional()
    public void delete(Long id) {
        if(!courseRepository.existsById(id)) {
            throw new EntityNotFoundException("Id não encontrado");
        }
        try {
            courseRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Falha na integridade referencial");
        }
    }
}
