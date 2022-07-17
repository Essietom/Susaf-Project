package com.univaq.susafProject.service;

import com.mongodb.DuplicateKeyException;
import com.univaq.susafProject.exception.DuplicateException;
import com.univaq.susafProject.exception.NotFoundException;
import com.univaq.susafProject.model.Synthesis;
import com.univaq.susafProject.repository.SynthesisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SynthesisService {
    SynthesisRepository synthesisRepository;

    public SynthesisService(SynthesisRepository synthesisRepository) {

        this.synthesisRepository = synthesisRepository;
    }

    public Synthesis getSynthesisByScopingId(String scopingId)
    {
        return synthesisRepository.findByScopingId(scopingId);
    }

    public List<Synthesis> getSytnthesisByUser()
    {
        return null;
    }

    public Synthesis saveSynthesis(Synthesis synthesis )
    {
        try{
            return synthesisRepository.save(synthesis);
        }catch(org.springframework.dao.DuplicateKeyException e){
           throw new DuplicateException("DUPLICATE KEY", "There's a synthesis for that scoping id already");
    }

    }

}
