package com.hasibur.CareerFootsteps.repository;

import com.hasibur.CareerFootsteps.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {
}
