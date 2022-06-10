package com.univaq.susafProject.controller;

import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.service.DimensionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/susaf/dimension")
public class DimensionController {
    private DimensionService dimensionService;

    public DimensionController(DimensionService dimensionService) {
        this.dimensionService = dimensionService;
    }

    @CrossOrigin
    @PostMapping("/add")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Dimension> addDimension(@RequestBody Dimension dimension, HttpServletResponse response){
        return new ResponseEntity<>(dimensionService.saveOrUpdateDimension(dimension), HttpStatus.OK) ;
    }

    @CrossOrigin
    @GetMapping("/all")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Dimension>> getDimension(HttpServletResponse response){
        return new ResponseEntity<>(dimensionService.getAllDimension(), HttpStatus.OK) ;
    }

    @CrossOrigin
    @PutMapping("/edit")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Dimension> editDimension(@RequestBody Dimension dimension, @RequestParam String dimensionId, HttpServletResponse response){
        return new ResponseEntity<>(dimensionService.updateDimension(dimension, dimensionId), HttpStatus.OK) ;
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteDimension(@RequestParam String dimensionId, HttpServletResponse response){
        dimensionService.deleteDimension(dimensionId);
    }


}
