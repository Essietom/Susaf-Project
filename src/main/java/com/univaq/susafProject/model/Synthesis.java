package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "opportunityandaction")
public class Synthesis {
    private List<ThreatnAction> threatnActions;
    private List<OpportunitynAction> opportunitynActions;
}
