package io.github.bbenefield.courseapidata.topics;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The '@Entity' annotation lets 'Spring' know that our class has been marked to create a table in the DB. Without
 * providing a specific name, 'Spring' assumes we want our table to have the same name as the class marked with the
 * '@Entity' annotation but in plural form, i.e. a class named 'Topic' will become 'Topics'. 'Spring' will also go ahead
 * and and fill in the new tables fields with our entity-class' properties/fields. In the example of our 'Topic' class,
 * the table name would be 'Topics' with three fields, 'id', 'name', 'description'.
 */
@Entity
public class Topic {

    // The '@Id' annotation lets 'Spring' know that this property will be our 'id' field in the DB
    @Id
    private String id;
    private String name;
    private String description;

    public Topic() {}

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
