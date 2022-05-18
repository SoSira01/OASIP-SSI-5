package com.example.booking.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BookFieldError {
    private String field;
    private String errorMessage;

}
