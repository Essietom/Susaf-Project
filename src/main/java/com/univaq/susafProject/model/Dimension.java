package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "dimensions")
public class Dimension {
    @Id
    private String id;
    private String name;
    private String description;
}
