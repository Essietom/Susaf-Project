package com.univaq.susafProject.controller;

import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Question;
import com.univaq.susafProject.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<Question> addQuestion(@RequestBody Question question, @RequestParam String topicId){
        return new ResponseEntity<>(questionService.saveOrUpdateQuestion(question, topicId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/get")
   // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<Question>> getQuestion(@RequestParam String dimensionId, HttpServletResponse response){
        return new ResponseEntity<>(questionService.getQuestionsByDimensionId(dimensionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/all")
   // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<Question>> getAllQuestion(HttpServletResponse response){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK) ;
    }

    @CrossOrigin
    @PutMapping("/edit")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Question> editQuestion(@RequestParam Question question, String questionId, HttpServletResponse response){
        return new ResponseEntity<>(questionService.updateQuestion(question, questionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteDimension(@RequestParam String questionId, HttpServletResponse response){
        questionService.delete(questionId);
    }

}
