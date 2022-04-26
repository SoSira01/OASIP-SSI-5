package com.example.booking.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import com.example.booking.entities.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Integer id;
    private String bookingName;
    private Instant startTime;
    private String email;
    private String note;
    private Category categoryCategory;
}
