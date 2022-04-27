package com.example.booking.repositories;

import com.example.booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
//    @Modifying
//    @Transactional
//    void deleteById(Integer Id);
}
