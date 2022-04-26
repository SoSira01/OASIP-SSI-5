package com.example.booking.services;

import com.example.booking.dtos.CategoryDTO;
import com.example.booking.entities.Category;
import com.example.booking.repositories.CategoryRepository;
import com.example.booking.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ListMapper listMapper;
    @Autowired
    private ModelMapper modelMapper;

    public List<CategoryDTO> getCategory () {
        List<Category> employeeList = repository.findAll();
        return listMapper.mapList(employeeList, CategoryDTO.class, modelMapper);
    }

}
