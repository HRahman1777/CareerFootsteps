package com.hasibur.CareerFootsteps.repository;

import com.hasibur.CareerFootsteps.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
