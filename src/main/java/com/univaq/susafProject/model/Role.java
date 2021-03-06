package com.univaq.susafProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String name;


}
