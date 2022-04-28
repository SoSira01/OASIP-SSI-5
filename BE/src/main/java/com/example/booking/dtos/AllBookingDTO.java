package com.example.booking.dtos;

import com.example.booking.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
public class AllBookingDTO {
    private Integer id;
    private String bookingName;
    private Instant startTime;
    private String email;
    private String note;

    private Integer categoryId;
    private String categoryName;
    private Integer categoryDuration;
    private String categoryDescription;
}
