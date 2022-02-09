package com.univaq.culturalHeritage;

import com.univaq.culturalHeritage.exception.NotFoundException;
import com.univaq.culturalHeritage.model.Booking;
import com.univaq.culturalHeritage.repository.BookingRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class Consumer {
    @Autowired
    private BookingRepository bookingRepository;

    @KafkaListener(topics = "${cloudkarafka.topic}")
    public void processMessage(String message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);

        int jsonStart=message.indexOf('{');
        int jsonEnd=message.lastIndexOf('}')+1;
        if(jsonStart>=0 && jsonEnd>jsonStart) {
            String jsonPart=message.substring(jsonStart,jsonEnd);
            System.out.println(jsonPart);
            JSONObject json = new JSONObject(jsonPart);
            String bookingId = json.getString("bookingId");
            String status = json.getString("status");
            updateBooking(bookingId, status);
        }
    }


    public void updateBooking(String bookingId, String status){
        Optional<Booking> oBooking = bookingRepository.findById(bookingId);
        Booking booking = oBooking.isPresent()? oBooking.get() :  null;
        if(booking == null){
            System.out.println("booking not found "+ bookingId);
            return ;
        }
        booking.setStatus(status);
        bookingRepository.save(booking);
        System.out.println("Updating booking with id "+ bookingId);
    }

}
