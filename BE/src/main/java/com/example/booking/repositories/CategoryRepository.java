package com.example.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.booking.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsCategoryByCategoryName(String categoryName);
}
