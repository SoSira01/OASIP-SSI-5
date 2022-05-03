package com.example.booking.dtos;

import com.example.booking.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {
    private Integer id;
    private String bookingName;
    private Instant startTime;
    @JsonIgnore
    private CategoryDTO category;

}
