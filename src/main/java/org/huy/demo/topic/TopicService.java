package org.huy.demo.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    private final List<Topic> topics = new ArrayList<>(List.of(
            new Topic("spring", "Spring Framework", "Learn Spring"),
            new Topic("java", "Java Core", "Learn Java"),
            new Topic("javascript", "JavaScript", "Learn Javascript")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics
                .stream()
                .filter(topic -> topic.getId().equals(id))
                .findAny()
                .orElseGet(() -> new Topic("Not found", null, null));
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}
