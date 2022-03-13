package com.hasibur.CareerFootsteps.service.category;

import com.hasibur.CareerFootsteps.model.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);

    public List<Category> getAllCategory();

    public Category getCategoryById(Long id);

    public Category getCategoryByName(String name);

    public void removeCategoryById(Long id);
}
