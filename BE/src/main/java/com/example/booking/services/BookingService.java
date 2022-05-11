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

    //validate
    private boolean checkEmail;
    private boolean checkDate;
    //validateEmail
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    //overlap StartTime
    public boolean OverlapStartTime(Integer categoryId, Date startTime){
        Category duration = categoryrepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category id : "+ categoryId+
                        "Does Not Exist !!!"
                ));
        Date endTime = new Date(startTime.getTime() + (1000*60*duration.getDuration()));
        List<Booking> book = repository.findAllByStartTimeBetween(startTime, endTime);
        return book.size() == 0;
    }
    //create booking
    public Booking create(BookingDTO newBooking) {
        try {
            Booking book = modelMapper.map(newBooking, Booking.class);
            checkEmail = validateEmail(book.getEmail());
            checkDate = OverlapStartTime(book.getCategory().getId(), book.getStartTime());
            if (checkEmail &&  checkDate) {
                return repository.saveAndFlush(book);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email must be well-formed; StartTime error");
            }
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Does Not Exist !!!", e.getCause());
        }
    }

    //get booking by id
    public BookingDTO getBookingById(Integer bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Booking id "+ bookingId+
                        "Does Not Exist !!!"
                ));
        return modelMapper.map(booking, BookingDTO.class);
    }

    //get booking by categoryId
//    public BookingDTO getIdByCategory(Integer CategoryId) {
//        Booking booking = repository.findById(CategoryId)
//                .orElseThrow(()-> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, "Category id : "+ CategoryId+
//                        "Does Not Exist !!!"
//                ));
//        return modelMapper.map(booking, BookingDTO.class);
//    }

    //delete booking
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        id + " does not exist !!!"));
        repository.deleteById(id);
    }
    //Edit
    public BookingDTO editBooking(EditBookingDTO editbookingdto, Integer id){
        try {
            Booking booking = modelMapper.map(editbookingdto, Booking.class);
            Booking bk = repository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Booking id" + id +
                            "does not exist !!!"
                    ));
            checkDate = OverlapStartTime(bk.getId(), bk.getStartTime());
            bk.setEmail(booking.getEmail());
            bk.setStartTime(booking.getStartTime());
            bk.setNote(booking.getNote());
            if (checkDate) {
                return modelMapper.map(bk,BookingDTO.class);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email must be well-formed; StartTime error");
            }
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Does Not Exist !!!", e.getCause());
        }
    }

}
