package com.univaq.susafProject.service;

import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Question;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.repository.DimensionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {
    DimensionRepository dimensionRepository;

    public QuestionService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public List<Question> getAllQuestions(String topicId, String dimensionId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topics = dimension.getTopic();
        List<Question> questions = topics.stream()
                .filter(t -> t.getId().equals(topicId))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("NOT FOUND", "The topic does not exist"))
                .getQuestion();

        return questions;
    }
    public Question getQuestionById(String dimensionId, String topicId, String questionId)
    {
        List<Question> questions = getAllQuestions(topicId, dimensionId);
        if(questions == null){
            questions = new ArrayList<Question>();
        }
        Question question = questions.stream().filter(q -> q.getId().equals(questionId))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("NOT FOUND", "The question does not exist"))
        ;
        return question;
    }

    public Question saveOrUpdateQuestion(Question question, String topicId, String dimensionId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topics = dimension.getTopic();

        Topic topic = topics.stream()
                .filter(t -> t.getId().equals(topicId))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("NOT FOUND", "The topic does not exist"))
                ;
        if(topic.getQuestion() == null){
            topic.setQuestion(new ArrayList<Question>());
        }
        topic.getQuestion().add(question);
        question.setId(String.valueOf(UUID.randomUUID()));
        dimensionRepository.save(dimension);
        return question;
    }

    public Question updateQuestion(Question  question, String topicId, String dimensionId )
    {

        return null;
    }


    public void delete(String questionId, String dimensionId, String topicId)
    {
        Dimension dimension  = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT FOUND", "The dimension does not exist"));
        List<Topic> topics = dimension.getTopic();

        List<Question> questions = topics.stream()
                .filter(t -> t.getId().equals(topicId))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("NOT FOUND", "The topic does not exist"))
                .getQuestion();
        questions.removeIf(
                q -> q.getId().equals(questionId)
        );
        dimensionRepository.save(dimension);

    }
}
