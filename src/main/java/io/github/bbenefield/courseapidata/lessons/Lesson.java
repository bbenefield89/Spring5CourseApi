package io.github.bbenefield.courseapidata.lessons;

import io.github.bbenefield.courseapidata.courses.Course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lesson {

    @Id
    private String id;
    private String lessonName;
    private String lessonDescription;

    @ManyToOne
    private Course course;

    public Lesson() {}

    public Lesson(String id, String lessonName, String lessonDescription) {
        this.id = id;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
