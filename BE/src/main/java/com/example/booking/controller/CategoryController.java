package com.example.booking.controller;

import com.example.booking.dtos.CategoryDTO;
import com.example.booking.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryservice;
    @GetMapping("")
    public List<CategoryDTO> getAllCategory() {
        return categoryservice.getCategory();
    }
}
