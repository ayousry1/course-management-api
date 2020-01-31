package com.course.example.coursemanagementapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    private TopicService topicService;

    public TopicController() {
    }

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return  topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable int id){
        return topicService.getTopicById(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics")
    public void updateTopicById(@RequestBody Topic topic){
        topicService.updateTopicById(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void removeTopicById(@PathVariable int id){
        topicService.removeTopicById(id);
    }
}
