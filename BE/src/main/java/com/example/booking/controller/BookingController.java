package com.example.booking.controller;

import com.example.booking.dtos.AllBookingDTO;
import com.example.booking.dtos.BookingDTO;
import com.example.booking.entities.Booking;
import com.example.booking.services.BookingService;
import org.springframework.web.bind.annotation.*;
import com.example.booking.services.BookingService;
import com.example.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingRepository repository;
    //get all working
//    @GetMapping("")
//    public Page<Booking> getAllBookings(
//            @RequestParam(defaultValue = "id") String sortBy,
//            @RequestParam(defaultValue = "0") Integer page,
//            @RequestParam(defaultValue = "5") Integer pageSize) {
//        Sort sort = Sort.by(sortBy);
//        return repository.findAll(PageRequest.of(page, pageSize, sort));
//    }
    @GetMapping("")
    public List<BookingDTO> getBookingById(){
        return  bookingservices.getBooking();
    }
    @Autowired
    private BookingService bookingservices;
    //get by id working
    @GetMapping("/{id}")
    public AllBookingDTO getBookingById(@PathVariable Integer id){
        return  bookingservices.getBookingById(id);
    }
    //create booking not working
    @PostMapping("")
    public Booking create(@RequestBody BookingDTO newBooking){
        return bookingservices.save (newBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        bookingservices.deleteById(id);
    }


}
