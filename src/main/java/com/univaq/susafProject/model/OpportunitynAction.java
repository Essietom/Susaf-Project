package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "opportunityandactions")
public class OpportunitynAction {
    @Id
    private String id;
    private String opportunity;
    private String action;
}
