package com.concretepage.service.impl;

import com.concretepage.entity.Article;
import com.concretepage.entity.Topic;
import com.concretepage.repository.TopicRepository;
import com.concretepage.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService implements ITopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> list = new ArrayList<>();
        topicRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Topic getTopicById(long topicId) {
        Topic topic = topicRepository.findById(topicId).get();
        return topic;
    }

    @Override
    public boolean addTopic(Topic topic) {
        List<Topic> list = topicRepository.findByTopicName(topic.getTopicName());
        if (list.size() > 0) {
            return false;
        } else {
            topicRepository.save(topic);
            return true;
        }
    }

    @Override
    public void updateTopic(Topic topic) {
        topicRepository.save(topic);

    }

    @Override
    public void deleteTopic(int topicId) {
        topicRepository.delete(getTopicById(topicId));

    }
}
