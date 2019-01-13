package io.github.bbenefield.courseapidata.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessonsByCourseId(String courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    public Optional<Lesson> getSingleLessonById(String lessonId) {
        return lessonRepository.findById(lessonId);
    }

    public void createLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void updateLesson(Lesson lesson) {
        createLesson(lesson);
    }

    public void deleteLesson(String lessonId) {
        lessonRepository.deleteById(lessonId);
    }

}
