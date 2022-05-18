package com.example.booking.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EditBookingDTO {
    private Integer id;
    @NotNull
    @FutureOrPresent
    private Date startTime;
    @Size(max = 500 ,message = "Notes must be lower than 500 or equal characters")
    private String note;
}
