package com.univaq.susafProject.dao;

import lombok.Data;

@Data
public class QuestionDao {
    private String id;
    private Double totalPrice;
    private String description;
    private String bookingDate;
    private String bookingTime;
    private String status;
    private int quantity;
    private String name;

}
