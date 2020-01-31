package com.course.example.coursemanagementapi;


import com.course.example.coursemanagementapi.topic.Topic;
import com.course.example.coursemanagementapi.topic.TopicRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TopicRepository topicRepository;


    @Test
    public void whenFindAll_thenReturnPersistedTopic() {
        // given
        Topic topicOne = new Topic(1 ,"topic 1" , "topic 1 description");
        entityManager.persist(topicOne);
        entityManager.flush();

        // when
        ArrayList<Topic> found = new ArrayList<>();
        topicRepository.findAll().forEach(found::add);


        // then
        Assert.notEmpty(found ,"testing that persistence happened");
        Assert.isTrue(found.get(0).getId() == topicOne.getId(),"testing that id is persisted correctly");
        Assert.isTrue(found.get(0).getName() == topicOne.getName(),"testing that name is persisted correctly");
        Assert.isTrue(found.get(0).getDescription() == topicOne.getDescription(),"testing that description is persisted correctly");
    }
}
