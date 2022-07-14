package com.univaq.susafProject.controller;

import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Synthesis;
import com.univaq.susafProject.service.DimensionService;
import com.univaq.susafProject.service.SynthesisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public ResponseEntity<Synthesis> addSynthesis(@RequestBody Synthesis synthesis, HttpServletResponse response){
        return new ResponseEntity<>(synthesisService.saveSynthesis(synthesis), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/all")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Synthesis>> getSynthesis(HttpServletResponse response){
        return new ResponseEntity<>(synthesisService.getSytnthesisByUser(), HttpStatus.OK) ;
    }
}
