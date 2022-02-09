package com.univaq.culturalHeritage.dao;

import lombok.Data;


@Data
public class UserBooking {
    private String id;
    private int quantity;
    private String date;
    private String time;
    private String userId;
    private String ticketId;
}
