package com.hasibur.CareerFootsteps.service.user;

import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void removeUserById(Long id) {
        userRepo.deleteById(id);
    }
}
