package com.example.booking.controller;

import com.example.booking.dtos.CategoryDTO;
import com.example.booking.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.booking.entities.Category;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryservice;
    //get all
    @GetMapping("")
    public List<CategoryDTO> getAllCategory() {
        return categoryservice.getCategory();
    }
    //get by id working
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Integer id){
        return  categoryservice.getCategoryById(id);
    }
    //create
    @PostMapping("")
    public Category create(@Valid @RequestBody CategoryDTO newCategory){
        return  categoryservice.create(newCategory);
    }
    //edit
    @PatchMapping("/{id}")
    public CategoryDTO editCategory(@Valid @RequestBody CategoryDTO editcategorydto,@PathVariable Integer id){
        return categoryservice.editCategory(editcategorydto, id);
    }
    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        categoryservice.deleteById(id);
    }
}
