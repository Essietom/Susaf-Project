package com.univaq.susafProject.service;

import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Question;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.repository.DimensionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    DimensionRepository dimensionRepository;

    public QuestionService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public List<Question> getAllQuestions(String dimensionId, String topicId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topic = dimension.getTopic();
        //iterate and return all questions with given topic id
        return null;
    }
    public Question getQuestionById(String dimension, String topicId, String questionId)
    {

        return null;
    }

    public Question saveOrUpdateQuestion(Question question, String topicId, String dimensionId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topic = dimension.getTopic();
        //iterate and get topic with given topic id, add question to it and update dimension
        return null;
    }

    public Question updateQuestion(Question  question, String topicId, String dimensionId )
    {

        return null;
    }


    public void delete(String questionId, String dimensionId, String topicId)
    {
    }
}
