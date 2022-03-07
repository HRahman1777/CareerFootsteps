package com.hasibur.CareerFootsteps.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @GetMapping
    public String mainPage(Model model){


        return "index.html";
    }

    @GetMapping("/home")
    public String homePage(Model model){


        return "home.html";
    }

    @GetMapping("/allpost")
    public String allPost(Model model){


        return "allpost.html";
    }

    @GetMapping("/single_post")
    public String singlePost(Model model){


        return "singlepost.html";
    }

    @GetMapping("/profile")
    public String userProfile(Model model){


        return "user/profile.html";
    }
}
