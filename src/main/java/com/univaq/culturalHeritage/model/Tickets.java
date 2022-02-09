package com.univaq.culturalHeritage.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tickets")
public class Tickets {
    @Id
    private String id;
    private String name;
    private Double price;
    private String description;
}
