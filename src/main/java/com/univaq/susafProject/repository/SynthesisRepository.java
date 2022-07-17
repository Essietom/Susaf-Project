package com.univaq.susafProject.repository;

import com.univaq.susafProject.model.Synthesis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SynthesisRepository extends MongoRepository<Synthesis, String> {
    Synthesis findByScopingId(String scopingId);
}
