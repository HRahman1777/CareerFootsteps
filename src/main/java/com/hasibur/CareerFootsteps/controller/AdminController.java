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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfo userInfo;

    @GetMapping("/admin")
    public String adminHome(Model model){

        User user = userInfo.userInfo();
        model.addAttribute("user", user);


        return "admin/dashboard.html";
    }

    @GetMapping("/admin/alluser")
    public String adminAllUser(Model model){

        model.addAttribute("users", userService.getAllUser());


        return "admin/all_user.html";
    }

    @GetMapping("/admin/allpost")
    public String adminAllPost(Model model){

        model.addAttribute("posts", postService.getAllPost());


        return "admin/all_post.html";
    }

    @GetMapping("/admin/allcategory")
    public String adminAllCategory(Model model){

        model.addAttribute("categories", categoryService.getAllCategory());


        return "admin/all_category.html";
    }
}
