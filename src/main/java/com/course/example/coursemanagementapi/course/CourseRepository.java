package com.course.example.coursemanagementapi.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Integer>{
    List<Course> findByTopicId(int topicId);
}
