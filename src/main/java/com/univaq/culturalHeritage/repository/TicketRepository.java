package com.univaq.culturalHeritage.repository;

import com.univaq.culturalHeritage.model.Tickets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Tickets, String> {
}
