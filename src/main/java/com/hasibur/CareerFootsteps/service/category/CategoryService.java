package com.hasibur.CareerFootsteps.service.category;

import com.hasibur.CareerFootsteps.model.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);

    public List<Category> getAllCategory();
}
