package com.hasibur.CareerFootsteps.service.category;


import com.hasibur.CareerFootsteps.model.Category;
import com.hasibur.CareerFootsteps.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).get();
    }
}
