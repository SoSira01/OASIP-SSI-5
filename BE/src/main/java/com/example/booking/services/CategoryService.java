package com.example.booking.services;

import com.example.booking.dtos.BookingDTO;
import com.example.booking.dtos.CategoryDTO;
import com.example.booking.entities.Booking;
import com.example.booking.entities.Category;
import com.example.booking.repositories.CategoryRepository;
import com.example.booking.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ListMapper listMapper;
    @Autowired
    private ModelMapper modelMapper;

    //get all
    public List<CategoryDTO> getCategory () {
        List<Category> category = repository.findAll();
        return listMapper.mapList(category, CategoryDTO.class, modelMapper);
    }

    //get booking by id
    public CategoryDTO getCategoryById(Integer categoryId) {
        Category category = repository.findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "category id "+ categoryId+
                        "Does Not Exist !!!"
                ));
        return modelMapper.map(category, CategoryDTO.class);
    }


}
