package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private Dimension dimension;
    private String description;
}
