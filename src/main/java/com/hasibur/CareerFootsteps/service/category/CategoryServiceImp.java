package com.hasibur.CareerFootsteps.service.category;


import com.hasibur.CareerFootsteps.model.Category;
import com.hasibur.CareerFootsteps.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }
}
