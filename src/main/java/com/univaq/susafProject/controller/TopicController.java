package com.univaq.susafProject.controller;

import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/susaf/topic")
public class TopicController {
    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @CrossOrigin
    @PostMapping("/add")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic, @RequestParam String dimensionId, HttpServletResponse response){
        return new ResponseEntity<>(topicService.saveOrUpdateTopic(topic, dimensionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/all")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Topic>> getTopic(@RequestParam String dimensionId){
        return new ResponseEntity<>(topicService.getAllTopic(dimensionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @PutMapping("/edit")
  //  @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Topic> editTopic(@RequestBody Topic topic,@RequestParam String topicId, String dimensionId, HttpServletResponse response){
        return new ResponseEntity<>(topicService.updateTopic(topic, topicId, dimensionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteTopic(@RequestParam String topicId,String dimensionId, HttpServletResponse response){
        topicService.deleteTopic(topicId, dimensionId);
    }

}
