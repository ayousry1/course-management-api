package com.course.example.coursemanagementapi.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/lessons")
    public List<Lesson> getAllLessons(){
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(1, "Lesson 1"));
        return lessons;
    }
}
