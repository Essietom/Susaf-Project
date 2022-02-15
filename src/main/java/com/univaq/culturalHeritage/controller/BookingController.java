package com.univaq.culturalHeritage.controller;

import com.univaq.culturalHeritage.dao.BookingDao;
import com.univaq.culturalHeritage.dao.UserBooking;
import com.univaq.culturalHeritage.exception.NotFoundException;
import com.univaq.culturalHeritage.model.Booking;
import com.univaq.culturalHeritage.model.Tickets;
import com.univaq.culturalHeritage.repository.BookingRepository;
import com.univaq.culturalHeritage.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private BookingRepository bookingRepository;
    private TicketRepository ticketRepository;

    public BookingController(BookingRepository bookingRepository, TicketRepository ticketRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTicket(@RequestBody UserBooking bookingDetail, HttpServletResponse response){
        Booking booking = new Booking();
        booking.setUserId(bookingDetail.getUserId());
        booking.setQuantity(bookingDetail.getQuantity());
        booking.setDate(bookingDetail.getDate());
        booking.setTicket(ticketRepository.findById(bookingDetail.getTicketId()).orElseThrow(()->new NotFoundException("NOT FOUND", "Ticket nOT fOUND")));
        booking.setTime(bookingDetail.getTime());
        booking.setId(bookingDetail.getId());
        booking.setStatus("NOT PAID");
        return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.OK) ;
    }

    @GetMapping("/available-tickets")
    public List<Tickets> getAvailableTickets(){
        return ticketRepository.findAll();
    }

    @PostMapping("/available-tickets/add")
    public Tickets addTickets(@RequestBody Tickets aTicket){
        return ticketRepository.save(aTicket);
    }

    @GetMapping("/{userid}")
    public List<BookingDao> getUserBooking(@PathVariable(value="userid") String userId, HttpServletResponse response){
        List<BookingDao> userBookinglist = new ArrayList<>();
        try {
            List<Booking> userBooking = bookingRepository.findByUserId(userId);
            for (Booking booking :
                    userBooking) {
                BookingDao aBooking = new BookingDao();
                aBooking.setTotalPrice(booking.getQuantity() * booking.getTicket().getPrice());
                aBooking.setBookingTime(booking.getTime());
                aBooking.setBookingDate(booking.getDate());
                aBooking.setDescription(booking.getTicket().getDescription());
                aBooking.setQuantity(booking.getQuantity());
                aBooking.setName(booking.getTicket().getName());
                aBooking.setStatus(booking.getStatus());
                aBooking.setId(booking.getId());
                userBookinglist.add(aBooking);
            }
            return userBookinglist;
        }catch (NotFoundException ex){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", ex);
        }

    }
}
