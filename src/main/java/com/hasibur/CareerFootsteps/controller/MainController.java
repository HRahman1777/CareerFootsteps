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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();
        model.addAttribute("UNAME", uname);

        return "index.html";
    }

    @GetMapping("/home")
    public String homePage(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();
        model.addAttribute("UNAME", uname);

        return "home.html";
    }

    @GetMapping("/allpost")
    public String allPost(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();
        model.addAttribute("UNAME", uname);

        return "allpost.html";
    }

    @GetMapping("/single_post")
    public String singlePost(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();
        model.addAttribute("UNAME", uname);

        return "singlepost.html";
    }

    @GetMapping("/profile")
    public String userProfile(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();
        model.addAttribute("UNAME", uname);

        return "user/profile.html";
    }
}
