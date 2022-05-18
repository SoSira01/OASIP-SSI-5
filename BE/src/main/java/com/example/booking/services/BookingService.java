package com.example.booking.services;

import com.example.booking.dtos.BookingDTO;
import com.example.booking.dtos.EditBookingDTO;
import com.example.booking.entities.Booking;
import com.example.booking.entities.Category;
import com.example.booking.repositories.BookingRepository;
import com.example.booking.repositories.CategoryRepository;
import com.example.booking.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;
    @Autowired
    private CategoryRepository categoryrepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    //get booking
    public List<BookingDTO> getBooking(){
        List<Booking> BookingList = repository.findAll(Sort.by("startTime").descending());
        return  listMapper.mapList(BookingList,BookingDTO.class,modelMapper);
    }

    //overlap StartTime
//    public boolean OverlapStartTime(Integer categoryId, Date startTime){
//        Category duration = categoryrepository.findById(categoryId)
//                .orElseThrow(() -> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, "Category id : "+ categoryId+
//                        "Not Found ID to Overlap"
//                ));
//        Date endTime = new Date(startTime.getTime() + (1000*60*duration.getDuration()));
//        List<Booking> book = repository.findAllByStartTimeBetween(startTime, endTime);
//        return book.size() == 0;
//    }

    //create booking
    public Booking create(BookingDTO newBooking) {
        Booking book = modelMapper.map(newBooking, Booking.class);
//
//        if (!OverlapStartTime(book.getCategory().getId(), book.getStartTime())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "StartTime error");
//        }
        return repository.saveAndFlush(book);
    }

    //get booking by id
    public BookingDTO getBookingById(Integer bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Booking id "+ bookingId+
                        "Get Booking By id Not found"
                ));
        return modelMapper.map(booking, BookingDTO.class);
    }

    //delete booking
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        id + "Not Found ID To Delete"));
        repository.deleteById(id);
    }
    //Edit
    public BookingDTO editBooking(EditBookingDTO editbookingdto, Integer id){
        Booking booking = modelMapper.map(editbookingdto, Booking.class);
        Booking bk = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Booking id" + id +
                        "Not found ID to Edit"
                ));
        bk.setStartTime(booking.getStartTime());
        bk.setNote(booking.getNote());
//        if (!OverlapStartTime(bk.getCategory().getId(), bk.getStartTime())) {
//           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "StartTime error");
//         }
        repository.saveAndFlush(bk);
        return modelMapper.map(bk,BookingDTO.class);
    }

}