package com.univaq.susafProject.service;


import com.univaq.susafProject.exception.DuplicateException;
import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Dimension;
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
        try {
            return dimensionRepository.save(dimension);
        }catch(org.springframework.dao.DuplicateKeyException e){
            throw new DuplicateException("DUPLICATE KEY", "There's a dimension with the same name already");
        }
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
        dimensionRepository.deleteById(dimensionId);
    }

}