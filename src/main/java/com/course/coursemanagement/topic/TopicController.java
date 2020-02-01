package com.course.coursemanagement.topic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ahmed Yousry
 *
 * this interface has all the topic controller configuration
 */
@RequestMapping("/topics")
public interface TopicController {
    /**
     * <p>this method returns all topics available in database
     * </p>
     * @return a list of topics
     */
    @RequestMapping
    List<Topic> getAllTopics();

    /**
     * <p>this method retrieves a topic by its id
     * </p>
     * @param id the id of the required topic
     * @return the requested topic
     */
    @RequestMapping("/{id}")
    Topic getTopicById(@PathVariable int id);

    /**
     * <p>this persists a topic in the database
     * </p>
     * @param topic a topic entity
     */
    @RequestMapping(method = RequestMethod.POST )
    void addTopic(@RequestBody Topic topic);

    /**
     * <p>this persists updates a specific topic
     * </p>
     * @param topic a topic entity
     */
    @RequestMapping(method = RequestMethod.PUT )
    void updateTopicById(@RequestBody Topic topic);

    /**
     * <p>this method removes a specific topic from database by its id
     * </p>
     * @param id the id of the  topic
     */
    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removeTopicById(@PathVariable int id);
}
