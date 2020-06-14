package com.concretepage.repository;

import com.concretepage.entity.Article;
import com.concretepage.entity.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findByTopicName(String topicName);

}
