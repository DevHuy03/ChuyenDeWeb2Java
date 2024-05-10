package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Category;
import com.macquochuy.exercise03.Repository.CategoryRepository;
import com.macquochuy.exercise03.service.CategoryService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(UuidGenerator categoryId) {
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
            Category updatedCategory = categoryRepository.save(existingCategory);
            return updatedCategory;
        }

        return null;
    }

    @Override
    public void deleteCategory(UuidGenerator categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
