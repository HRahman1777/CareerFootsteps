package com.hasibur.CareerFootsteps.auth;

import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserInfo {

    @Autowired
    UserService userService;

    public User userInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();

        User user = userService.getUserByUsername(uname);

        if(user == null){
            user = null;
        }

        return user;
    }
}
