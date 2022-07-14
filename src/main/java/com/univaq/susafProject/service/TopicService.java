package com.univaq.susafProject.service;

import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.repository.DimensionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    DimensionRepository dimensionRepository;

    public TopicService(DimensionRepository dimensionRepository) {
        dimensionRepository = dimensionRepository;
    }

    public Topic saveOrUpdateTopic(Topic topic, String dimensionId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> updatedTopics = dimension.getTopic();
        if(updatedTopics == null){
            updatedTopics = new ArrayList<Topic>();
        }
        updatedTopics.add(topic);
        dimension.setTopic(updatedTopics);
        dimensionRepository.save(dimension);
        return topic;
    }

    public Topic updateTopic(Topic topic, String topicId, String dimensionId)
    {

//        Dimension oldDimension = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Dimension not found"));
//        List<Topic> oldTopics = oldDimension.getTopic();
//
//
//        List<Topic> updatedTopics = oldTopics.stream()
//                .filter(t -> t.getId().equals(topicId))
//                .findFirst()
//                .map(o -> o.getDescription() == topic.getDescription() ? topic.getDescription() : o)
//                ;
//
//        oldDimension.setTopic(updatedTopics);
//         dimensionRepository.save(oldDimension);
//        return topic;
        return null;

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
        //iterate through topics, remove topic with given id and update dimension
    }

    public Topic getTopicById(String topicId, String dimensionId) {
        Dimension dimension = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> updatedTopics = dimension.getTopic();
        //return topic with the given id
        return null;
    }

}
