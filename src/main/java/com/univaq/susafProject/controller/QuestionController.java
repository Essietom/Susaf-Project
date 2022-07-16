package com.univaq.susafProject.controller;

import com.univaq.susafProject.model.Question;
import com.univaq.susafProject.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/susaf/question")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @CrossOrigin
    @PostMapping("/add")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question, @RequestParam String topicId, @RequestParam String dimensionId){
        return new ResponseEntity<>(questionService.saveOrUpdateQuestion(question, topicId, dimensionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/get")
   // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Question> getQuestion(@RequestParam String dimensionId,@RequestParam String topicId,@RequestParam String questionId, HttpServletResponse response){
        return new ResponseEntity<>(questionService.getQuestionById(dimensionId, topicId, questionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/all")
   // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<Question>> getAllQuestion(@RequestParam String dimensionId, @RequestParam String topicId, HttpServletResponse response){
        return new ResponseEntity<>(questionService.getAllQuestions(topicId, dimensionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @PutMapping("/edit")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Question> editQuestion(@RequestBody Question question, @RequestParam String dimensionId, @RequestParam String topicId, @RequestParam String questionId){
        return new ResponseEntity<>(questionService.updateQuestion(question, topicId, dimensionId, questionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteDimension(@RequestParam String questionId,@RequestParam String dimensionId, @RequestParam String topicId, HttpServletResponse response){
        questionService.delete(questionId, dimensionId, topicId);
    }

}
