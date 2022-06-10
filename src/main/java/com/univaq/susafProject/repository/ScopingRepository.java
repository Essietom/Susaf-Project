package com.univaq.susafProject.repository;

import com.univaq.susafProject.model.Scoping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScopingRepository extends MongoRepository<Scoping, String> {


}

