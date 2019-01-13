package io.github.bbenefield.courseapidata.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicsController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    /**
     * Wrapping a portion of a URL in curly braces, e.g. '{}', along with adding the '@PathVariable' in to the methods
     * list of arguments will act as a parameter for the URL. Something like "/topics/{topicId}" and having a
     * parameter of 'topicId' will automatically map whatever argument is passed as the 'topicId' when the method is
     * called to the URL. If your URL parameter differs from the parameters name in the method you must then pass the
     * '@PathVariable' a string argument that matches your endpoints parameter,
     * i.e. if '@RequestMapping("/topics/{foo}")' and the method is
     * 'public Topic getTopicById(@PathVariable String topicId)', we must then pass the '@PathVariable' the string
     * 'topicId', e.g. 'public Topic getTopicById(@PathVariable("topicId") String topicId)'.
     */
    @RequestMapping("/topics/{topicId}")
    public Optional<Topic> getTopicById(@PathVariable("topicId") String topicId) {
        return topicService.getTopicById(topicId);
    }

    /**
     * The '@RequestMapping' annotation can accept mulitple arguments. One of these arguments is the 'method' which lets
     * 'Spring' know what type of HTTP request this endpoint will be used with. By default, '@RequestMapping' takes a
     * string which maps that string to the URL for this endpoint. When providing multiple arguments, we need to
     * explicitly tell 'Spring' the URL we want to use by providing the 'value' argument.
     */
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/topics"
    )
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/topics/{topicId}"
    )
    public void deleteTopic(@PathVariable String topicId) {
        topicService.deleteTopic(topicId);
    }

    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/topics/{topicId}"
    )
    public void updateTopic(@RequestBody Topic topic, @PathVariable String topicId) {
        topicService.updateTopic(topic, topicId);
    }

}
