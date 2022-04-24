package com.example.booking.controller;

import com.example.booking.entities.Booking;
import com.example.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingRepository repository;
    @GetMapping("")
    public Page<Booking> getAllCustomers(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Sort sort = Sort.by(sortBy);
        return repository.findAll(PageRequest.of(page, pageSize, sort));
    }
}
