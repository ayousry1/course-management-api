package com.course.example.coursemanagementapi.course;

import com.course.example.coursemanagementapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    public CourseController() {
    }

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCoursesByTopicId(@PathVariable int topicId){
        return  courseService.getAllCoursesByTopicId(topicId);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}/courses")
    public void addCourseUnderTopic(@RequestBody Course course , @PathVariable int topicId){
        course.setTopic(new Topic(topicId));
        courseService.addCourseUnderTopic(course);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}/courses")
    public void updateCourseById(@RequestBody Course course, @PathVariable int topicId){
        course.setTopic(new Topic(topicId));
        courseService.updateCourseById(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/courses/{id}")
    public void removeCourseById(@PathVariable int id){
        courseService.removeCourseById(id);
    }
}
