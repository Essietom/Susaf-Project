package com.univaq.susafProject.service;

import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Question;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic saveOrUpdateTopic(Topic topic)
    {
        //Topic oldTopic = topicRepository.findById(topicId).orElseThrow(() -> new NotFoundException("", ""));

        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic, String topicId)
    {
        Topic oldTopic = topicRepository.findById(topicId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Topic Not Found"));

        if(topic.getDescription() != null){
            oldTopic.setDescription(topic.getDescription());
        }
        if(topic.getName() != null){
            oldTopic.setName(topic.getName());
        }
        return topicRepository.save(oldTopic);
    }

    public List<Topic> getAllTopic()
    {
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topic1 -> topics.add(topic1));
        return topics;
    }

    public void deleteTopic(String topicId)
    {
        Topic topic = topicRepository.findById(topicId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Topic not found"));
        topicRepository.delete(topic);
    }

    public Topic getTopicById(String topicId)
    {
        return topicRepository.findById(topicId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Topic not found"));
    }


}
