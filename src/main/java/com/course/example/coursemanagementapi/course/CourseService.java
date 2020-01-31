package com.course.example.coursemanagementapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService() {
    }

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course topic) {
        courseRepository.save(topic);
    }

    public void updateCourseById(Course topic) {
        courseRepository.save(topic);
    }

    public void removeCourseById(int id) {
        courseRepository.deleteById(id);
    }
}
