package com.hasibur.CareerFootsteps.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminHome(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();

        model.addAttribute("UNAME", uname);
        model.addAttribute("AUTH", auth);

        return "admin/dashboard.html";
    }
}
