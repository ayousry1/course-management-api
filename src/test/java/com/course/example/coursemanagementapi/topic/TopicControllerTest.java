package com.course.example.coursemanagementapi.topic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(TopicController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    private static String topicOneName = "topic 1";
    private static String topicOneDescription = "topic 1 description";
    private static int topicOneId = 1;
    private  Topic topicOneTestObj;

    @Before
    public void setUp(){
        topicOneTestObj = new Topic(topicOneId, topicOneName, topicOneDescription);
        List<Topic> allTopics = Arrays.asList(topicOneTestObj);
        given(topicService.getAllTopics()).willReturn(allTopics);
        given(topicService.getTopicById(topicOneId)).willReturn(topicOneTestObj);
    }


    @Test
    public void givenTopics_whenGetAllTopics_thenReturnJsonArray() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .get("/topics")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(topicOneTestObj.getName()));
    }
}
