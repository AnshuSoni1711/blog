package com.concretepage.controller;

import com.concretepage.entity.Article;
import com.concretepage.entity.Topic;
import com.concretepage.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("blog")
public class TopicController {

    @Autowired
    ITopicService topicService;

    @GetMapping("topics")
    public ResponseEntity<List<Topic>> getAllTopic() {
        List<Topic> list = topicService.getAllTopics();
        return new ResponseEntity<List<Topic>>(list, HttpStatus.OK);
    }

    @GetMapping("topic/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable("id") Integer id) {
        Topic topic = topicService.getTopicById(id);
        return new ResponseEntity<Topic>(topic, HttpStatus.OK);
    }

    @PostMapping("topic")
    public ResponseEntity<Void> addTopic(@RequestBody Topic topic, UriComponentsBuilder builder) {
        boolean flag = topicService.addTopic(topic);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/topic/{id}").buildAndExpand(topic.getUid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("topic")
    public ResponseEntity<Topic> updateArticle(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
        return new ResponseEntity<Topic>(topic, HttpStatus.OK);
    }
    @DeleteMapping("topic/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
        topicService.deleteTopic(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
