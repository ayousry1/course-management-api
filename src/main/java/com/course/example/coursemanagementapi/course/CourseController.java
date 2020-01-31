package com.course.example.coursemanagementapi.course;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "course 1" ));
        return courses;
    }
}