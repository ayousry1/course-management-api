package com.course.example.coursemanagementapi.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topicList = new ArrayList<Topic>(Arrays.asList(
            new Topic(1,"topic 1" , "topic description"),
            new Topic(2,"topic 2" , "topic description"),
            new Topic(3,"topic 3" , "topic description")
    ));
    public List<Topic> getAllTopics() {
        return topicList;
    }

    public Topic getTopicById(int topicId){
        return topicList.stream().filter(topic -> topic.getId() == topicId).findFirst().get();
    }

    public void addTopic(Topic topic){
        topicList.add(topic);
    }

    public void updateTopicById(Topic topic , int topicId){
        for(int i = 0 ; i < topicList.size() ;i++){
            Topic t = topicList.get(i);
            if (t.getId() == topicId){
                topicList.set(i,topic);
            }
        }
    }

    public void removeTopicById(int id){
        topicList.removeIf(topic -> topic.getId() == id);
    }
}
