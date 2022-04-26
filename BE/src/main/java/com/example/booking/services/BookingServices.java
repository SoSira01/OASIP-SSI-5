package com.example.booking.services;

import com.example.booking.dtos.BookingDTO;
import com.example.booking.entities.Booking;
import com.example.booking.repositories.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookingServices {
    @Autowired
    private BookingRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    //create booking
    public Booking save(BookingDTO newBooking) {
        Booking e = modelMapper.map(newBooking, Booking.class);
        return repository.saveAndFlush(e);
    }
    //get booking by id
    public BookingDTO getBookingById(Integer bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Booking id "+ bookingId+
                        "Does Not Exist !!!"
                ));
        return modelMapper.map(booking, BookingDTO.class);
    }
    //delete booking
//        public  Booking delete(BookingDTO id){
//            Booking e = modelMapper.map(id,Booking.class);
//        return repository.delete(e);
//    } not complete
}
