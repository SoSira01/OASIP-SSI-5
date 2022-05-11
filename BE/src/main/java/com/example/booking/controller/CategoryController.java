package com.example.booking.controller;

import com.example.booking.dtos.BookingDTO;
import com.example.booking.dtos.CategoryDTO;
import com.example.booking.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //get by id working
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Integer id){
        return  categoryservice.getCategoryById(id);
    }
}
