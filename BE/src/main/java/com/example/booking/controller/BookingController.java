package com.example.booking.controller;

import com.example.booking.dtos.BookingDTO;
import com.example.booking.dtos.EditBookingDTO;
import com.example.booking.entities.Booking;
import com.example.booking.services.BookingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
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
    public BookingDTO getBookingById(@PathVariable Integer id){
        return  bookingservices.getBookingById(id);
    }
    //create booking
    @PostMapping("")
    public Booking create(@Valid @RequestBody BookingDTO newBooking){
        return bookingservices.create(newBooking);
    }
    //delete booking
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        bookingservices.deleteById(id);
    }
    //edit booking
    @PatchMapping("/{id}")
    public BookingDTO editBooking(@Valid  @RequestBody EditBookingDTO editbookingdto,@PathVariable Integer id){
        return bookingservices.editBooking(editbookingdto ,id);
    }
}
