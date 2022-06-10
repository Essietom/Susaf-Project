package com.univaq.susafProject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Set<Role> roles;
    private boolean tokenExpired;
}
