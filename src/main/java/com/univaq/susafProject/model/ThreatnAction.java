package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "threatandaction")
public class ThreatnAction {
    @Id
    private String id;
    private String threat;
    private String action;
}
