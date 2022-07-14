package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Data
//@Document(collection = "topic")
public class Topic {
    @Id
    private String id;
    private String name;
    private String description;
    private ArrayList<Question> question;
}
