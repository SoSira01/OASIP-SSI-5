package com.example.booking.controller;

import com.example.booking.entities.Category;
import com.example.booking.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;
    @GetMapping("")
    public List<Category> getOffices() {
        return repository.findAll();
    }
}
