package io.github.bbenefield.courseapidata.courses;

import io.github.bbenefield.courseapidata.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Optional<Course> getCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }

    @RequestMapping(
        method = RequestMethod.POST,
        value = "/topics/{topicId}/courses"
    )
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/topics/{topicId}/courses/{courseId}"
    )
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }

    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/topics/{topicId}/courses/{courseId}"
    )
    public void updateCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

}
