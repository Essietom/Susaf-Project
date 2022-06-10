package com.univaq.susafProject.service;

import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Scoping;
import com.univaq.susafProject.repository.DimensionRepository;
import com.univaq.susafProject.repository.ScopingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScopingService {
    ScopingRepository scopingRepository;

    public ScopingService(ScopingRepository scopingRepository) {

        this.scopingRepository = scopingRepository;
    }

    public Scoping getScopingByIdAndUser()
    {
       return null;
//       return scopingRepository.findByIdAndUserId();
    }

    public List<Scoping> getScopingByUser()
    {
       return null;
//       return scopingRepository.findByUserId();
    }

    public Scoping saveScoping(Scoping scoping )
    {
        return scopingRepository.save(scoping);
    }

}
