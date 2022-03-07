package com.hasibur.CareerFootsteps.controller;


import com.hasibur.CareerFootsteps.auth.UserInfo;
import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.category.CategoryService;
import com.hasibur.CareerFootsteps.service.post.PostService;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    //=========     Normal Routing     =====>>>>>
    //===========================================


    @GetMapping("/user/home")
    public String homePage(Model model){

        model.addAttribute("post_form", new Post());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("posts",postService.getAllPost());


        return "home.html";
    }

    @GetMapping("/user/allpost")
    public String allPost(Model model){


        return "allpost.html";
    }

    @GetMapping("/user/single_post/{pid}")
    public String singlePost(@PathVariable("pid") Long id, Model model){

        model.addAttribute("post",postService.getPostById(id));

        return "single_post.html";
    }

    @GetMapping("/user/profile")
    public String userProfile(Model model) {

        model.addAttribute("post_form", new Post());
        model.addAttribute("categories", categoryService.getAllCategory());

        User user = userInfo.userInfo();
        model.addAttribute("user", user);

        model.addAttribute("posts", postService.getPostByUser(user));


        return "user/profile.html";
    }


    //===========================================
    //========= CRUD Site              =====>>>>>
    //===========================================


    @PostMapping("/user/posted")
    public String userPosted(Post post){

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = localDateTime.format(format);
        post.setTime(formatDateTime);

        User main_user = userInfo.userInfo();
        post.setUser(main_user);

        postService.addPost(post);

        return "redirect:/user/home";
    }


}
