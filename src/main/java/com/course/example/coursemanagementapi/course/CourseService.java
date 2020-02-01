package com.course.example.coursemanagementapi.course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCoursesByTopicId(int topicId);
    Course getCourseById(int id);
    void addCourseUnderTopic(Course course);
    void updateCourseById(Course course);
    void removeCourseById(int id);
}
