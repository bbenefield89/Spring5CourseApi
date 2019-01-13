package io.github.bbenefield.courseapidata.lessons;

import io.github.bbenefield.courseapidata.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Lessonontroller {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessonsByCourseId(@PathVariable String courseId) {
        return lessonService.getAllLessonsByCourseId(courseId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public Optional<Lesson> getSingleLessonById(@PathVariable String lessonId) {
        return lessonService.getSingleLessonById(lessonId);
    }

    @RequestMapping(
        method = RequestMethod.POST,
        value = "/topics/{topicId}/courses/{courseId}/lessons"
    )
    public void createLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
        lesson.setCourse(new Course(courseId, "", "", topicId));
        lessonService.createLesson(lesson);
    }

    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}"
    )
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
        createLesson(lesson, topicId, courseId);
    }

    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}"
    )
    public void deleteLessons(@PathVariable String lessonId) {
        lessonService.deleteLesson(lessonId);
    }

}
