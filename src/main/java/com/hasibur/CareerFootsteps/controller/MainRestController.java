package com.hasibur.CareerFootsteps.controller;

import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @Autowired
    private UserService userService;

    @PostMapping("user/add")
    private User userAdd(@RequestBody User user){
        return userService.addUser(user);
    }

}
