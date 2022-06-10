package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "scoping")
public class Scoping {
    @Id
    private String id;
    private User user;
    private String productName;
    private String productVision;
    private List<String> knownSustainabilityEffects;
}
