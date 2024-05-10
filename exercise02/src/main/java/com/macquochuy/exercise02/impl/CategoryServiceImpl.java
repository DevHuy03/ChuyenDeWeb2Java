package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Category;
import com.macquochuy.exercise02.Repository.CategoryRepository;
import com.macquochuy.exercise02.service.CategoryService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> optionalExistingCategory = categoryRepository.findById(category.getCategory_id());

        if (optionalExistingCategory.isPresent()) {
            Category existingCategory = optionalExistingCategory.get();
            existingCategory.setCategory_title(category.getCategory_title());
            existingCategory.setSub_category_id(category.getSub_category_id());
            existingCategory.setImage_url(category.getImage_url());
            existingCategory.setProducts(category.getProducts());
            existingCategory.setSub_category_id(category.getSub_category_id());
            existingCategory.setSubcategories(category.getSubcategories());
            // existingCategory.setLikes(category.getLikes());
            existingCategory.setUpdated_at(category.getUpdated_at());

            return categoryRepository.save(existingCategory);
        } else {
            // Trả về null nếu danh mục không tồn tại
            return null;
        }
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
