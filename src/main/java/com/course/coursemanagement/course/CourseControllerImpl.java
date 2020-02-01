package com.course.coursemanagement.course;

import com.course.coursemanagement.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseControllerImpl implements CourseController{

    private CourseServiceImpl courseServiceImpl;

    public CourseControllerImpl() {
    }

    @Autowired
    public CourseControllerImpl(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    public List<Course> getAllCoursesByTopicId(@PathVariable int topicId){
        return  courseServiceImpl.getAllCoursesByTopicId(topicId);
    }

    public Course getCourseById(@PathVariable int id){
        return courseServiceImpl.getCourseById(id);
    }

    public void addCourseUnderTopic(@RequestBody Course course , @PathVariable int topicId){
        course.setTopic(new Topic(topicId));
        courseServiceImpl.addCourseUnderTopic(course);
    }

    public void updateCourseById(@RequestBody Course course, @PathVariable int topicId){
        course.setTopic(new Topic(topicId));
        courseServiceImpl.updateCourseById(course);
    }

    public void removeCourseById(@PathVariable int id){
        courseServiceImpl.removeCourseById(id);
    }
}
