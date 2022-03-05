package com.hasibur.CareerFootsteps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String mainPage(){

        return "index.html";
    }

    @GetMapping("/home")
    public String homePage(){

        return "home.html";
    }

    @GetMapping("/allpost")
    public String allPost(){

        return "allpost.html";
    }

    @GetMapping("/singlepost")
    public String singlePost(){

        return "singlepost.html";
    }

    @GetMapping("/profile")
    public String userProfile(){

        return "user/profile.html";
    }
}
