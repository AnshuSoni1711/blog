package com.concretepage.service;

import com.concretepage.entity.Article;
import com.concretepage.entity.Topic;

import java.util.List;

public interface ITopicService {

    List<Topic> getAllTopics();
    Topic getTopicById(long topicId);
    boolean addTopic(Topic topic);
    void updateTopic(Topic topic);
    void deleteTopic(int topicId);
}
