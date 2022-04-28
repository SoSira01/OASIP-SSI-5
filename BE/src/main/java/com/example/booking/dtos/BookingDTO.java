package com.example.booking.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {
    private Integer id;
    private String bookingName;
    private Instant startTime;
    private String email;
    private String note;
}
