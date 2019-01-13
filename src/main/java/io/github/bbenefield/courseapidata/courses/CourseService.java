package io.github.bbenefield.courseapidata.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // getAllCourses
    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    // getCourseById
    public Optional<Course> getCourseById(String topicId) {
        return courseRepository.findById(topicId);
    }

    // addCourse
    public void addCourse(Course topic) {
        courseRepository.save(topic);
    }


    // deleteCourse
    public void deleteCourse(String topicId) {
        courseRepository.deleteById(topicId);
    }

    // updateCourse
    public void updateCourse(Course topic) {
        courseRepository.save(topic);
    }

}
