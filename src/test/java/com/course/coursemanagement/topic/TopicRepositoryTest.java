package com.course.coursemanagement.topic;



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

    private static String topicOneName = "topic 1";
    private static String topicOneDescription = "topic 1 description";
    private static int topicOneId = 1;


    @Test
    public void whenFindAll_thenReturnPersistedTopic() {
        // given
        Topic topicOne = new Topic(topicOneId ,topicOneName , topicOneDescription);
        entityManager.persist(topicOne);
        entityManager.flush();

        // when
        ArrayList<Topic> found = new ArrayList<>();
        topicRepository.findAll().forEach(found::add);


        // then
        Assert.notEmpty(found ,"testing that persistence happened");
        Assert.isTrue(found.get(0).getId() == topicOne.getId(),"testing that id is persisted correctly");
        Assert.isTrue(found.get(0).getName().equals(topicOne.getName()) ,"testing that name is persisted correctly");
        Assert.isTrue(found.get(0).getDescription().equals(topicOne.getDescription()),"testing that description is persisted correctly");
    }
}
