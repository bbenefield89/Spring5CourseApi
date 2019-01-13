package io.github.bbenefield.courseapidata.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    // getAllTopics
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    // getTopicById
    public Optional<Topic> getTopicById(String topicId) {
        return topicRepository.findById(topicId);
    }

    // addTopic
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }


    // deleteTopic
    public void deleteTopic(String topicId) {
        topicRepository.deleteById(topicId);
    }

    // updateTopic
    public void updateTopic(Topic topic, String topicId) {
        topicRepository.save(topic);
    }

}
