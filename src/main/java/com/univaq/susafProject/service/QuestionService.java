package com.univaq.susafProject.service;

import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Question;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.repository.QuestionRepository;
import com.univaq.susafProject.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    QuestionRepository questionRepository;
    TopicRepository topicRepository;

    public QuestionService(QuestionRepository questionRepository, TopicRepository topicRepository) {
        this.questionRepository = questionRepository;
        this.topicRepository = topicRepository;
    }

    public List<Question> getAllQuestions()
    {
        List<Question> questions = new ArrayList<Question>();
        questionRepository.findAll().forEach(question1 -> questions.add(question1));
        return questions;
    }
    public List<Question> getQuestionsByDimensionId(String dimension)
    {
        List<Question> questions = new ArrayList<Question>();
        questionRepository.findByDimension(dimension).forEach(question1 -> questions.add(question1));
        return questions;
    }

    public Question saveOrUpdateQuestion(Question question, String topicId)
    {
        Topic topic  = topicRepository.findById(topicId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The topic does not exist"));
        ArrayList<Question> updatedQuestions = topic.getQuestion();
        updatedQuestions.add(question);
        topic.setQuestion(updatedQuestions);
        topicRepository.save(topic);
       return question;
    }

    public Question updateQuestion(Question  question, String questionId )
    {
        Question oldQuestion = questionRepository.findById(questionId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Question not found"));
        if(question.getDescription() != null){
            oldQuestion.setDescription(question.getDescription());
        }

        return questionRepository.save(oldQuestion);
    }


    public void delete(String questionId)
    {
        questionRepository.deleteById(questionId);
    }
}
