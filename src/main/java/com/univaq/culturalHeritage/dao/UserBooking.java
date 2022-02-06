package com.univaq.culturalHeritage.dao;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class UserBooking {
    private long id;
    private int quantity;
    private String date;
    private String time;
    private long userId;
    private long ticketId;
}
