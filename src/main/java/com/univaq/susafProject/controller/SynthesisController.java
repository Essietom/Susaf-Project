package com.univaq.susafProject.controller;

import com.univaq.susafProject.model.Synthesis;
import com.univaq.susafProject.service.SynthesisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/susaf/synthesis")
public class SynthesisController {
    private SynthesisService synthesisService;

    public SynthesisController(SynthesisService synthesisService) {
        this.synthesisService = synthesisService;
    }

    @CrossOrigin
    @PostMapping("/add")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Synthesis> addSynthesis(@RequestBody Synthesis synthesis){
        return new ResponseEntity<>(synthesisService.saveSynthesis(synthesis), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/get")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Synthesis> getSynthesisByScopingId(@RequestParam String scopingId){
        return new ResponseEntity<>(synthesisService.getSynthesisByScopingId(scopingId), HttpStatus.OK) ;
    }
}
