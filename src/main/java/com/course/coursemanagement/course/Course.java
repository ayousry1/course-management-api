package com.course.coursemanagement.course;

import com.course.coursemanagement.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
    @Id
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

    public Course() {
    }

    public Course(int id, String name, Topic topic) {
        this.id = id;
        this.name = name;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
