package com.example.booking.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "CategoryId", nullable = false)
    private Integer id;

    @Column(name = "CategoryName", nullable = false, length = 100)
    private String categoryName;

    @Column(name = "Duration", nullable = false, length = 45)
    private Integer duration;

    @Column(name = "CategoryDescription", nullable = false, length = 500)
    private String categoryDescription;

    @OneToMany(mappedBy = "categoryCategory")
    private Set<Booking> bookings = new LinkedHashSet<>();

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}