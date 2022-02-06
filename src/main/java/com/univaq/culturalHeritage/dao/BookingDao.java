package com.univaq.culturalHeritage.dao;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class BookingDao {
    private long id;
    private Double totalPrice;
    private String description;
    private String bookingDate;
    private String bookingTime;
    private String status;
    private int quantity;
    private String name;

}
