package com.hasibur.CareerFootsteps.controller;

import com.hasibur.CareerFootsteps.auth.UserInfo;
import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.category.CategoryService;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserInfo userInfo;


    @GetMapping
    public String mainPage(Model model){


        return "index.html";
    }

    @GetMapping("/user/home")
    public String homePage(Model model){

        User user = userInfo.userInfo();
        model.addAttribute("userid", user.getId());
        model.addAttribute("post_form", new Post());
        model.addAttribute("categories", categoryService.getAllCategory());

        return "home.html";
    }

    @GetMapping("/user/allpost")
    public String allPost(Model model){


        return "allpost.html";
    }

    @GetMapping("/user/single_post")
    public String singlePost(Model model){


        return "singlepost.html";
    }
}
