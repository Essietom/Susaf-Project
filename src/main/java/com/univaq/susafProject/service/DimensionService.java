package com.univaq.susafProject.service;


import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Topic;
import com.univaq.susafProject.repository.DimensionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DimensionService {

    DimensionRepository dimensionRepository;

    public DimensionService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public List<Dimension> getAllDimension()
    {
        List<Dimension> dimensions = new ArrayList<Dimension>();
        dimensionRepository.findAll().forEach(dimension1 -> dimensions.add(dimension1));
        return dimensions;
    }

        public Dimension saveOrUpdateDimension(Dimension dimension )
    {
        return dimensionRepository.save(dimension);
    }

    public Dimension updateDimension(Dimension dimension, String dimensionId )
    {
        Dimension oldDimension = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Dimension not found"));
        if(dimension.getDescription() != null){
            oldDimension.setDescription(dimension.getDescription());
        }
        if(dimension.getName() != null){
            oldDimension.setName(dimension.getName());
        }
        return dimensionRepository.save(oldDimension);
    }


    public void deleteDimension(String dimensionId)
    {
        Dimension dimension = dimensionRepository.findById(dimensionId).orElseThrow(() -> new NotFoundException("NOT_FOUND", "Dimension not found"));
        dimensionRepository.deleteById(dimensionId);
    }

}