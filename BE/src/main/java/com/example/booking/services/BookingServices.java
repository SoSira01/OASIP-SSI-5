package com.example.booking.services;

import com.example.booking.dtos.AllBookingDTO;
import com.example.booking.dtos.BookingDTO;
import com.example.booking.entities.Booking;
import com.example.booking.repositories.BookingRepository;
import com.example.booking.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingServices {
    @Autowired
    private BookingRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;
    //get booking
    public List<BookingDTO> getBooking(){
        List<Booking> BookingList = repository.findAll();
        return  listMapper.mapList(BookingList,BookingDTO.class,modelMapper);
    }
    //create booking
    public Booking save(BookingDTO newBooking) {
        Booking booking = modelMapper.map(newBooking, Booking.class);
        return repository.save(booking);
    }
    //get booking by id
    public AllBookingDTO getBookingById(Integer bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Booking id "+ bookingId+
                        "Does Not Exist !!!"
                ));
        return modelMapper.map(booking, AllBookingDTO.class);
    }

    //delete booking
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        id + " does not exist !!!"));
        repository.deleteById(id);
    }
}
