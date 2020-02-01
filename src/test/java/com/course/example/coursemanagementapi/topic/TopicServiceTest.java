package com.course.example.coursemanagementapi.topic;

import com.course.example.coursemanagementapi.topic.Topic;
import com.course.example.coursemanagementapi.topic.TopicRepository;
import com.course.example.coursemanagementapi.topic.TopicService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest
{
    @MockBean
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    private static String topicOneName = "topic 1";
    private static String topicOneDescription = "topic 1 description";
    private static int topicOneId = 1;

    @Before
    public void setUp(){
        Topic topicOneTestObj = new Topic(topicOneId, topicOneName, topicOneDescription);
        ArrayList<Topic> topicsList = new ArrayList<>();
        topicsList.add(topicOneTestObj);

        Iterator<Topic> topicsIterator = topicsList.iterator();

        Mockito.when(topicRepository.findById(topicOneId)).thenReturn(java.util.Optional.ofNullable(topicOneTestObj));
    }

    @Test
    public void whenGetTopicById_thenReturnTopicOneTestObj(){
        Topic actual = topicService.getTopicById(topicOneId);

        Assert.assertNotNull(actual);
        Assert.assertEquals(topicOneId, actual.getId());
        Assert.assertEquals(topicOneName, actual.getName());
        Assert.assertEquals(topicOneDescription, actual.getDescription());
    }
}
