package com.univaq.susafProject.repository;

import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimensionRepository extends MongoRepository<Dimension, String> {
}
