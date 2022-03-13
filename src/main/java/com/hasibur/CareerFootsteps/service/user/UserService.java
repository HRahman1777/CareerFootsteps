package com.hasibur.CareerFootsteps.service.user;

import com.hasibur.CareerFootsteps.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public User getUserByUsername(String username);

    public List<User> getAllUser();

    public User getUserById(Long id);

    public void removeUserById(Long id);
}
