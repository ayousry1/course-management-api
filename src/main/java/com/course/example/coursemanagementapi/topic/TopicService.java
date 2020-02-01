package com.course.example.coursemanagementapi.topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopics();
    Topic getTopicById(int topicId);
    void addTopic(Topic topic);
    void updateTopicById(Topic topic);
    void removeTopicById(int id);
}
