package com.univaq.susafProject.repository;

import com.univaq.susafProject.model.Scoping;
import com.univaq.susafProject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScopingRepository extends MongoRepository<Scoping, String> {
    List<Scoping> findByUser(User user);
    Scoping findByIdAndUserId(String id, String user);
}

