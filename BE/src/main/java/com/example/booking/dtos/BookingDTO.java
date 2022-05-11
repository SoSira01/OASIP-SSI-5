package com.example.booking.dtos;

import com.example.booking.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {
    private Integer id;
    private String bookingName;
    private Date startTime;
    private String email;
    private String note;
    @JsonIgnore
    private Integer categoryId;
    private String categoryName;
    private Integer categoryDuration;
    private String categoryDescription;

}
