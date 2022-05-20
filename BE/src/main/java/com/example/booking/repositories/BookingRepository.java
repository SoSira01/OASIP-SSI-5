package com.example.booking.repositories;

import com.example.booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
//    List<Booking> findAllByStartTimeBetween(Date startTime, Date endTime);
    List<Booking> findBycategoryIdOrderByStartTimeDesc(Integer categoryId);
//    List<Booking> findBycategoryId(Integer categoryId);
}
