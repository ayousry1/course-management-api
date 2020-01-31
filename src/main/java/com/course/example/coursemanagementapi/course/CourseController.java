package com.course.example.coursemanagementapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


    @RequestMapping("/courses")
    public List<Course> getAllCourses(){
        return  courseService.getAllCourses();
    }

    @RequestMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/courses")
    public void addCourse(@RequestBody Course topic){
        courseService.addCourse(topic);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/courses")
    public void updateCourseById(@RequestBody Course topic){
        courseService.updateCourseById(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/courses/{id}")
    public void removeCourseById(@PathVariable int id){
        courseService.removeCourseById(id);
    }
}
