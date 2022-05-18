package com.example.booking.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
public class BookExceptionModel {
    private HttpStatus status;
    private String message;
    private List<BookFieldError> details;

    public BookExceptionModel(HttpStatus status, String message, List<BookFieldError> details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public BookExceptionModel(HttpStatus status, String message, BookFieldError detail) {
        super();
        this.status = status;
        this.message = message;
        details = List.of(detail);
    }
}
