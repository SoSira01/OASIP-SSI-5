package com.example.booking.controller;

import com.example.booking.dtos.BookingDTO;
import org.springframework.data.domain.Page;
import com.example.booking.entities.Booking;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import com.example.booking.services.BookingServices;
import com.example.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingRepository repository;
    //get all
    @GetMapping("")
    public Page<Booking> getAllBookings(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer pageSize) {
        Sort sort = Sort.by(sortBy);
        return repository.findAll(PageRequest.of(page, pageSize, sort));
    }

    @Autowired
    private BookingServices bookingservices;
    //get by id
    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable Integer id){
        return  bookingservices.getBookingById(id);
    }
    //create booking
    @PostMapping("")
    public Booking create(@RequestBody BookingDTO newBooking){
        return bookingservices.save(newBooking);
    }

    //delete Booking id
//    @DeleteMapping("/{id}")
//    public Booking delete(@PathVariable BookingDTO id){
//        return bookingService.delete (id);
//    }  not complete !!
}
