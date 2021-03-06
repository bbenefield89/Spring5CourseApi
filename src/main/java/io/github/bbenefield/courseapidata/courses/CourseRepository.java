package io.github.bbenefield.courseapidata.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * A 'Repository', e.g. 'TopicRepository', is an interface we can create to tell 'Spring' to generate some very common
 * methods for each table in our DB that we create a corresponding 'Repository' for. You must extend the
 * 'CrudRepository' interface which comes from the 'Spring JPA' dependency for this to work.
 *
 * The 'CrudRepository' interface takes two arguments:
 *   - Type (Which 'Entity' does this 'Repository' relate to)
 *   - IdType (What data type is the 'id' property of the 'Entity' this 'Repository' relates to)
 */
public interface CourseRepository extends CrudRepository<Course, String> {

    // We are able to create our own CRUD methods by using similar naming conventions as 'Spring'
    public List<Course> findByTopicId(String topicId);

}
