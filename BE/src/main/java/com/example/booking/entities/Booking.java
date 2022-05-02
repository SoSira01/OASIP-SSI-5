package com.example.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "BookingId", nullable = false)
    private Integer id;

    @Column(name = "BookingName", nullable = false, length = 100)
    private String bookingName;

    @Column(name = "StartTime", nullable = false)
    private Instant startTime;

    @Column(name = "Email", length = 45)
    private String email;

    @Column(name = "Note")
    private String note;
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Category_CategoryId", nullable = false)
    private Category category;

}