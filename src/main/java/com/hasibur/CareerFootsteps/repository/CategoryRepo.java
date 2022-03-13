package com.hasibur.CareerFootsteps.repository;

import com.hasibur.CareerFootsteps.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("FROM Category WHERE name = ?1")
    public Category findByName(String name);
}
