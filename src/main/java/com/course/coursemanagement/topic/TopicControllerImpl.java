package com.course.coursemanagement.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicControllerImpl implements TopicController{

    private TopicServiceImpl topicServiceImpl;

    public TopicControllerImpl() {
    }

    @Autowired
    public TopicControllerImpl(TopicServiceImpl topicServiceImpl) {
        this.topicServiceImpl = topicServiceImpl;
    }

    public List<Topic> getAllTopics(){
        return  topicServiceImpl.getAllTopics();
    }

    public Topic getTopicById(@PathVariable int id){
        return topicServiceImpl.getTopicById(id);
    }

    public void addTopic(@RequestBody Topic topic){
        topicServiceImpl.addTopic(topic);
    }

    public void updateTopicById(@RequestBody Topic topic){
        topicServiceImpl.updateTopicById(topic);
    }

    public void removeTopicById(@PathVariable int id){
        topicServiceImpl.removeTopicById(id);
    }
}
