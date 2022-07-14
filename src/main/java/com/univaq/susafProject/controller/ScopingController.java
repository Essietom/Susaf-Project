package com.univaq.susafProject.controller;

import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Scoping;
import com.univaq.susafProject.service.DimensionService;
import com.univaq.susafProject.service.ScopingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/susaf/scoping")
public class ScopingController {
    private ScopingService scopingService;

    public ScopingController(ScopingService scopingService) {
        this.scopingService = scopingService;
    }

    @CrossOrigin
    @PostMapping("/add")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Scoping> addScoping(@RequestBody Scoping scoping, HttpServletResponse response){
        return new ResponseEntity<>(scopingService.saveScoping(scoping), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/all")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Scoping>> getScopingsForUser(HttpServletResponse response){
        return new ResponseEntity<>(scopingService.getScopingByUser(), HttpStatus.OK) ;
    }
}
