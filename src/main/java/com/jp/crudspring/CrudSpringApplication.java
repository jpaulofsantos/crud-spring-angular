package com.jp.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jp.crudspring.model.Course;
import com.jp.crudspring.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			List<Course> courseList = new ArrayList<>();

			Course course = new Course();
			course.setName("Angular");
			course.setCategory("Frontend");
			courseList.add(course);

			Course course2 = new Course();
			course2.setName("Java");
			course2.setCategory("Backend");
			courseList.add(course2);

			Course course3 = new Course();
			course3.setName("Android");
			course3.setCategory("Frontend");
			courseList.add(course3);

			Course course4 = new Course();
			course4.setName("C#");
			course4.setCategory("Backend");
			courseList.add(course4);

			Course course5 = new Course();
			course5.setName("Spring Boot");
			course5.setCategory("Backend");
			courseList.add(course5);

			Course course6 = new Course();
			course6.setName("React");
			course6.setCategory("Frontend");
			courseList.add(course6);

			courseRepository.saveAll(courseList);
		};
	}
}
