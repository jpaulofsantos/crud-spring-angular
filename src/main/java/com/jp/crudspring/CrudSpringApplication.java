package com.jp.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jp.crudspring.model.Course;
import com.jp.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course course = new Course();
			course.setName("Angular");
			course.setCategory("Frontend");
			courseRepository.save(course);

			Course course2 = new Course();
			course2.setName("Java");
			course2.setCategory("Backend");

			courseRepository.save(course2);
		};

	}

}
