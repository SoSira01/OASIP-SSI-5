package com.example.booking.Exception;

import com.example.booking.repositories.CategoryRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueExceptionHandler implements ConstraintValidator<Unique,String> {
    private  final CategoryRepository repository;

    public UniqueExceptionHandler(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String categoryName, ConstraintValidatorContext context) {
        return !repository.existsCategoryByCategoryName(categoryName);
    }
}
