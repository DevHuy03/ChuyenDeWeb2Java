package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    void deleteCategory(Long categoryId);
}
