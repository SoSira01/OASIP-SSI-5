package com.example.booking.controller;

import com.example.booking.dtos.BookingDTO;
import com.example.booking.dtos.DetailBookingDTO;
import com.example.booking.entities.Booking;
import com.example.booking.services.BookingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/booking")
public class BookingController {
    //get all working
    @GetMapping("")
    public List<BookingDTO> getAllBooking(){
        return  bookingservices.getBooking();
    }
    @Autowired
    private BookingService bookingservices;
    //get by id working
    @GetMapping("/{id}")
    public DetailBookingDTO getBookingById(@PathVariable Integer id){
        return  bookingservices.getBookingById(id);
    }
    //create booking
    @PostMapping("")
    public Booking create(@RequestBody BookingDTO newBooking){
        return bookingservices.create(newBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        bookingservices.deleteById(id);
    }


}
