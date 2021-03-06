package com.course.coursemanagement.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl() {
    }

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
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
