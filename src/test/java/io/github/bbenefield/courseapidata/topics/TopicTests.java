package io.github.bbenefield.courseapidata.topics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TopicTests {

    private Topic topic;

    @Before
    public void setUp() {
        topic = new Topic("spring", "Spring Framework", "Spring Framework Description");
    }

    @Test
    public void getId() {
        assertNotNull(topic.getId());
        assertNotEquals("sprin", topic.getId());
        assertEquals("spring", topic.getId());
    }

    @Test
    public void setId() {
        topic.setId("node");

        assertNotNull(topic.getId());
        assertNotEquals("spring", topic.getId());
        assertEquals("node", topic.getId());
    }

    @Test
    public void getName() {
        assertNotNull(topic.getName());
        assertNotEquals("Node Framework", topic.getName());
        assertEquals("Spring Framework", topic.getName());
    }

    @Test
    public void setName() {
        topic.setName("Node Framework");

        assertNotNull(topic.getName());
        assertNotEquals("Spring Framework", topic.getName());
        assertEquals("Node Framework", topic.getName());
    }

    @Test
    public void getDescription() {
        assertNotNull(topic.getDescription());
        assertNotEquals("Foo Bar FooBar", topic.getDescription());
        assertEquals("Spring Framework Description", topic.getDescription());
    }

    @Test
    public void setDescription() {
        topic.setDescription("Node Framework Description");

        assertNotNull(topic.getDescription());
        assertNotEquals("Spring Framework Description", topic.getDescription());
        assertEquals("Node Framework Description", topic.getDescription());
    }

}