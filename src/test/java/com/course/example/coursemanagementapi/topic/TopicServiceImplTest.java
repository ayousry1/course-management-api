package com.course.example.coursemanagementapi.topic;


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


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceImplTest
{
    @MockBean
    private TopicRepository topicRepository;

    @Autowired
    private TopicServiceImpl topicServiceImpl;

    private static String topicOneName = "topic 1";
    private static String topicOneDescription = "topic 1 description";
    private static int topicOneId = 1;

    @Before
    public void setUp(){
        Topic topicOneTestObj = new Topic(topicOneId, topicOneName, topicOneDescription);
        ArrayList<Topic> topicsList = new ArrayList<>();
        topicsList.add(topicOneTestObj);

        Mockito.when(topicRepository.findById(topicOneId)).thenReturn(java.util.Optional.ofNullable(topicOneTestObj));
    }

    @Test
    public void whenGetTopicById_thenReturnTopicOneTestObj(){
        Topic actual = topicServiceImpl.getTopicById(topicOneId);

        Assert.assertNotNull(actual);
        Assert.assertEquals(topicOneId, actual.getId());
        Assert.assertEquals(topicOneName, actual.getName());
        Assert.assertEquals(topicOneDescription, actual.getDescription());
    }
}
