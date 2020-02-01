package com.course.example.coursemanagementapi.topic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/topics")
public interface TopicController {
    @RequestMapping
    List<Topic> getAllTopics();

    @RequestMapping("/{id}")
    Topic getTopicById(@PathVariable int id);

    @RequestMapping(method = RequestMethod.POST )
    void addTopic(@RequestBody Topic topic);

    @RequestMapping(method = RequestMethod.PUT )
    void updateTopicById(@RequestBody Topic topic);

    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removeTopicById(@PathVariable int id);
}
