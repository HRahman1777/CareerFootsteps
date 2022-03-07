package com.hasibur.CareerFootsteps.controller;


import com.hasibur.CareerFootsteps.auth.UserInfo;
import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfo userInfo;

    @GetMapping("/login")
    public String login() {

        User user = userInfo.userInfo();
        if (user == null) {
            return "user/signin.html";
        } else {
            return "redirect:/logout_warning";
        }

    }

    @GetMapping("/signup")
    public String userSignup(Model model) {
        
        model.addAttribute("user", new User());

        User user = userInfo.userInfo();

        if (user == null) {
            return "user/signup.html";
        } else {
            return "redirect:/logout_warning";
        }

    }

    @PostMapping("/process_signup")
    public String processSignup(User user) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.addUser(user);

        return "/user/signup_success.html";
    }

    @GetMapping("/access_denied")
    public String accessDeniedPage() {

        return "user/access_denied.html";
    }

    @GetMapping("/logout_warning")
    public String logoutWarning() {

        return "user/logout_warning.html";
    }


    @PostMapping("/user/logout")
    public String customLogout(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }


    //===========================================
    //========= POST, PROFILE, SETTINGS =====>>>>>
    //===========================================


    @GetMapping("/user/profile")
    public String userProfile(Model model) {

        String uname = userInfo.userInfo().getUsername();

        User user = userInfo.userInfo();
        model.addAttribute("user", user);

        return "user/profile.html";
    }


}
