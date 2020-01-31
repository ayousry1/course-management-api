package com.course.example.coursemanagementapi.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LessonController {


    private LessonService lessonService;

    public LessonController() {
    }

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping("/lessons")
    public List<Lesson> getAllLessons(){
        return  lessonService.getAllLessons();
    }

    @RequestMapping("/lessons/{id}")
    public Lesson getLessonById(@PathVariable int id){
        return lessonService.getLessonById(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/lessons")
    public void addTopic(@RequestBody Lesson lesson){
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/lessons")
    public void updateLessonById(@RequestBody Lesson lesson){
        lessonService.updateLessonById(lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/lessons/{id}")
    public void removeLessonById(@PathVariable int id){
        lessonService.removeLessonById(id);
    }
}
