package com.hasibur.CareerFootsteps.repository;

import com.hasibur.CareerFootsteps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
