package com.example.booking.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
public class DetailBookingDTO {

        private Integer id;
        private String bookingName;
        private Instant startTime;
        private String email;
        private String note;
        @JsonIgnore
        private Integer categoryId;
        private String categoryName;
        private Integer categoryDuration;
        private String categoryDescription;

    }