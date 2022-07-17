package com.univaq.susafProject.service;

import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Scoping;
import com.univaq.susafProject.repository.ScopingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScopingService {
    ScopingRepository scopingRepository;

    public ScopingService(ScopingRepository scopingRepository) {

        this.scopingRepository = scopingRepository;
    }

    public Scoping getScopingById(String scopingId)
    {
       return scopingRepository.findById(scopingId)
               .orElseThrow(() -> new NotFoundException("NOT FOUND", "The scoping does not exist"));
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
