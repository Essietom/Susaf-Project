package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "synthesis")
public class Synthesis {
    @Id
    private String id;
    @Indexed(unique = true, background = true)
    private String scopingId;
    private List<ThreatnAction> threatnActions;
    private List<OpportunitynAction> opportunitynActions;
}
