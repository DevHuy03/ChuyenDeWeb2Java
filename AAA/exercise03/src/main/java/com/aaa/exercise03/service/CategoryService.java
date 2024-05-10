package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.Category;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(UUID categoryId);

    List<Category> getAllCategories();
    
    Category updateCategory(Category category);

    void deleteCategory(UUID categoryId);
}