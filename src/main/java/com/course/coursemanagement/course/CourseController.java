package com.course.coursemanagement.course;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Ahmed Yousry
 *
 * this interface has all the course controller configuration
 */
@RequestMapping("/courses")
public interface CourseController {
    /**
     * <p>this method returns all courses for a specific topic
     * </p>
     * @param topicId the id of the topic
     * @return a list of courses
     */
    @RequestMapping("/topics/{topicId}")
    List<Course> getAllCoursesByTopicId(@PathVariable int topicId);

    /**
     * <p>this method returns a course by its id
     * </p>
     * @param id the id of the topic
     * @return required course
     */
    @RequestMapping("/{id}")
    Course getCourseById(@PathVariable int id);

    /**
     * <p>this method add a course to database
     * </p>
     * @param course the new course
     * @param topicId the id of the topic
     */
    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}")
    void addCourseUnderTopic(@RequestBody Course course , @PathVariable int topicId);

    /**
     * <p>this method updates a specific course
     * </p>
     * @param course the updated course
     * @param topicId the topic id associated with the course
     */
    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}")
    void updateCourseById(@RequestBody Course course, @PathVariable int topicId);

    /**
     * <p>this method removes a specific course from database
     * </p>
     * @param id the course id
     */
    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removeCourseById(@PathVariable int id);

}
