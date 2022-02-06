package com.univaq.culturalHeritage.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.Date;

@Data
@Document(collection = "bookings")
public class Booking {
    @Id
    private long id;
    private int quantity;
    private String date;
    private String time;
    private long userId;
    private Tickets ticket;

}
