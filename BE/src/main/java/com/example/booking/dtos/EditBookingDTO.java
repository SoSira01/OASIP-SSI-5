package com.example.booking.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EditBookingDTO {
    private Integer id;
    private Date startTime;
    private String email;
    private String note;
}
