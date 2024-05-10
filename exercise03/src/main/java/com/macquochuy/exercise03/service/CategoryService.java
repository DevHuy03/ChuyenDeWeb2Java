package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Category;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(UuidGenerator categoryId);

    List<Category> getAllCategories();
    
    Category updateCategory(Category category);

    void deleteCategory(UuidGenerator categoryId);
}