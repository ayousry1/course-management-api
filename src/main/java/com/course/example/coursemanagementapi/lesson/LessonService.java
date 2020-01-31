package com.course.example.coursemanagementapi.lesson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {
    private LessonRepository lessonRepository;

    public LessonService() {
    }

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessons() {
        ArrayList<Lesson> lessons = new ArrayList<>();
        lessonRepository.findAll().forEach(lessons::add);
        return lessons;
    }

    public Lesson getLessonById(int id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void updateLessonById(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void removeLessonById(int id) {
        lessonRepository.deleteById(id);
    }
}
