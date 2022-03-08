package com.hasibur.CareerFootsteps.controller;


import com.hasibur.CareerFootsteps.auth.UserInfo;
import com.hasibur.CareerFootsteps.model.Comment;
import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.category.CategoryService;
import com.hasibur.CareerFootsteps.service.comment.CommentService;
import com.hasibur.CareerFootsteps.service.post.PostService;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;


    //===========================================
    //=========      USER AUTH         =====>>>>>
    //===========================================


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
    public String processSignup(@Valid User user, BindingResult result) {

        User check_user = userService.getUserByUsername(user.getUsername());
        if (check_user != null) {
            ObjectError error = new ObjectError("username", "");
            result.rejectValue("username", "error.user", "An account already exists for this username.");
            return "user/signup.html";
        }

        if (result.hasErrors()) {
            return "user/signup.html";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.addUser(user);

        return "/user/signup_success.html";
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
    //=========  Normal Routing - GET  =====>>>>>
    //===========================================

    @GetMapping("/user/home")
    public String homePage(Model model) {

        model.addAttribute("post_form", new Post());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("posts", postService.getAllPost());


        return "home.html";
    }

    @GetMapping("/access_denied")
    public String accessDeniedPage() {

        return "user/access_denied.html";
    }

    @GetMapping("/logout_warning")
    public String logoutWarning() {

        return "user/logout_warning.html";
    }

    @GetMapping("/user/profile")
    public String userProfile(Model model) {

        model.addAttribute("post_form", new Post());
        model.addAttribute("categories", categoryService.getAllCategory());

        User user = userInfo.userInfo();
        model.addAttribute("user", user);

        model.addAttribute("posts", postService.getPostByUser(user)); //user.postList can be alternative


        return "user/profile.html";
    }


}
