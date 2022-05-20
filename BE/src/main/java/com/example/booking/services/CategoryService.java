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
    //Create
    public Category create(CategoryDTO newCategory) {
        Category category = modelMapper.map(newCategory, Category.class);
        return repository.saveAndFlush(category);
    }
    //Edit
    public CategoryDTO editCategory(CategoryDTO editcategorydto, Integer id){
        Category category = modelMapper.map(editcategorydto, Category.class);
        Category ct = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Booking id" + id +
                        "Not found ID to Edit"
                ));
        ct.setCategoryName(category.getCategoryName());
        ct.setDuration(category.getDuration());
        ct.setCategoryDescription(category.getCategoryDescription());

        repository.saveAndFlush(ct);
        return modelMapper.map(ct,CategoryDTO.class);
    }
    //delete booking
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        id + "Not Found ID To Delete"));
        repository.deleteById(id);
    }
}
