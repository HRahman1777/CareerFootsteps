package com.hasibur.CareerFootsteps.repository;

import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @Query("FROM Post WHERE user = ?1")
    public List<Post> getPostByUser(User user);

    @Query("FROM Post WHERE title LIKE %?1%")
    public List<Post> findBySearchKeyword(String sKey);
}
