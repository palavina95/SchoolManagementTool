package com.example.schoolmanagementtool;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.schoolmanagementtool.domain.StudentDAOImpl;

@SpringBootApplication
public class SchoolmanagementtoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagementtoolApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(StudentDAOImpl studentDAO) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			// Insert some demo data
	        /*
	        studentDAO.save(new Student("John", "West"));
	        studentDAO.save(new Student("Mike", "Mars"));
	        studentDAO.save(new Student("Kate", "Johnson"));
	        */
	       
		};
	}	

}
