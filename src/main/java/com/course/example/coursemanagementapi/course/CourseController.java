package com.course.example.coursemanagementapi.course;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/courses")
public interface CourseController {
    @RequestMapping("/topics/{topicId}")
    List<Course> getAllCoursesByTopicId(@PathVariable int topicId);

    @RequestMapping("/{id}")
    Course getCourseById(@PathVariable int id);

    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}")
    void addCourseUnderTopic(@RequestBody Course course , @PathVariable int topicId);

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}")
    void updateCourseById(@RequestBody Course course, @PathVariable int topicId);

    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removeCourseById(@PathVariable int id);

}
