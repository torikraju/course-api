package com.springboot.restAPI.courese.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restAPI.courese.model.Topic;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("java", "Core Java", "Core Java description"),
			new Topic("thymeleaf", "Thymeleaf Template Engine", "Thymeleaf Template Engine description"),
			new Topic("spring", "Spring Framework", "Spring Framework description"),
			new Topic("hibernate", "Hibernate Framework", "Hibernate Framework description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
	}

	public void saveTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {

		for (int i = 0; i < topics.size(); i++) {
			Topic currentTopic = topics.get(i);
			if (currentTopic.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id){
		topics.removeIf(t->t.getId().equals(id));
	}

}
