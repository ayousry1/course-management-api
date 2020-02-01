package com.course.coursemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ahmed Yousry
 *
 * this class is the starting point of the application.
 * its annotated with @EnableSwagger2 to enable swagger documentation.
 */
@SpringBootApplication
@EnableSwagger2
public class CourseManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementApiApplication.class, args);
	}

}
