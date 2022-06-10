package com.univaq.susafProject.service;

import com.univaq.susafProject.model.Scoping;
import com.univaq.susafProject.model.Synthesis;
import com.univaq.susafProject.repository.ScopingRepository;
import com.univaq.susafProject.repository.SynthesisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SynthesisService {
    SynthesisRepository synthesisRepository;

    public SynthesisService(SynthesisRepository synthesisRepository) {

        this.synthesisRepository = synthesisRepository;
    }

    public Synthesis getSynthesisByIdAndUser()
    {
        return null;
//        return synthesisRepository.findByIdAndUserId();
    }

    public List<Synthesis> getSytnthesisByUser()
    {
        return null;
//        return scopingRepository.findByUserId();
    }

    public Synthesis saveSynthesis(Synthesis synthesis )
    {
        return synthesisRepository.save(synthesis);
    }

}
