package com.aaa.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.aaa.exercise03.Repository.CategoryRepository;
import com.aaa.exercise03.entity.Category;
import com.aaa.exercise03.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(UUID categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> optionalExistingCategory = categoryRepository.findById(category.getId());
        if (optionalExistingCategory.isPresent()) {
            Category existingCategory = optionalExistingCategory.get();
            existingCategory.setParent_id(category.getParent_id());
            existingCategory.setCategory_name(category.getCategory_name());
            existingCategory.setCategory_description(category.getCategory_description());
            existingCategory.setIcon(category.getIcon());
            existingCategory.setImage(category.getImage());
            existingCategory.setPlaceholder(category.getPlaceholder());
            existingCategory.setActive(category.isActive());
            existingCategory.setUpdated_at(LocalDateTime.now());
            Category updatedCategory = categoryRepository.save(existingCategory);
            return updatedCategory;
        }

        return null;
    }

    @Override
    public void deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
