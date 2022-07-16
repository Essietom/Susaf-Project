package com.univaq.susafProject.service;

import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.repository.DimensionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TopicService {
    DimensionRepository dimensionRepository;

    public TopicService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public Topic saveOrUpdateTopic(Topic topic, String dimensionId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> updatedTopics = dimension.getTopic();
        if(updatedTopics == null){
            updatedTopics = new ArrayList<Topic>();
        }
        topic.setId(String.valueOf(UUID.randomUUID()));
        updatedTopics.add(topic);
        dimension.setTopic(updatedTopics);
        dimensionRepository.save(dimension);
        return topic;
    }

    public Topic updateTopic(Topic topic, String topicId, String dimensionId)
    {

        Dimension oldDimension = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Dimension not found"));
        List<Topic> oldTopics = oldDimension.getTopic();
        if(oldTopics == null) throw new NotFoundException("NOT FOUND", "The topic does not exist");
        Topic oldTopic = oldTopics.stream()
                .filter(t -> t.getId().equals(topicId))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("NOT FOUND", "The topic does not exist"))
                ;
        if(topic.getDescription() != null){
            oldTopic.setDescription(topic.getDescription());
        }
        if(topic.getName() != null){
            oldTopic.setName(topic.getName());
        }
         dimensionRepository.save(oldDimension);
        return oldTopic;

    }

    public List<Topic> getAllTopic(String dimensionId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topics = dimension.getTopic();
        return topics;
    }

    public void deleteTopic(String topicId, String dimensionId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topics = dimension.getTopic();
        topics.removeIf(
                t -> t.getId().equals(topicId)
        );
        dimensionRepository.save(dimension);
    }

    public Topic getTopicById(String topicId, String dimensionId) {
        Dimension dimension = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topics = dimension.getTopic();
        if(topics == null) throw new NotFoundException("NOT FOUND", "The topic does not exist");
        Topic topic = topics.stream()
        .filter(t -> t.getId().equals(topicId))
        .findFirst()
                .orElseThrow(()-> new NotFoundException("NOT FOUND", "The topic does not exist"))
        ;
        return topic;
    }

}
