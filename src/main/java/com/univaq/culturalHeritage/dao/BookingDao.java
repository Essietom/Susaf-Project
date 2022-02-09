package com.univaq.culturalHeritage.dao;

import lombok.Data;

@Data
public class BookingDao {
    private String id;
    private Double totalPrice;
    private String description;
    private String bookingDate;
    private String bookingTime;
    private String status;
    private int quantity;
    private String name;

}
