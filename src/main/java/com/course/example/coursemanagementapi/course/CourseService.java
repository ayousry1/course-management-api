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

    public List<Course> getAllCoursesByTopicId(int topicId) {
        ArrayList<Course> courses = new ArrayList<>();
        courseRepository
                .findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourseUnderTopic(Course course) {
        courseRepository.save(course);
    }

    public void updateCourseById(Course course) {
        courseRepository.save(course);
    }

    public void removeCourseById(int id) {
        courseRepository.deleteById(id);
    }
}
