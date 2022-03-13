package com.hasibur.CareerFootsteps.controller;

import com.hasibur.CareerFootsteps.auth.UserInfo;
import com.hasibur.CareerFootsteps.model.Category;
import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.category.CategoryService;
import com.hasibur.CareerFootsteps.service.post.PostService;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    public String adminHome(Model model) {

        User user = userInfo.userInfo();
        model.addAttribute("user", user);


        return "admin/dashboard.html";
    }

    @GetMapping("/admin/alluser")
    public String adminAllUser(Model model) {

        model.addAttribute("users", userService.getAllUser());


        return "admin/all_user.html";
    }

    @GetMapping("/admin/allpost")
    public String adminAllPost(Model model) {

        model.addAttribute("posts", postService.getAllPost());


        return "admin/all_post.html";
    }

    @GetMapping("/admin/allcategory")
    public String adminAllCategory(Model model) {

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("category_form", new Category());

        return "admin/all_category.html";
    }

    @GetMapping("/admin/all_category/remove/{cid}")
    public String removeCategory(@PathVariable("cid") Long id) {

        Category checkCategory = categoryService.getCategoryById(id);
        if (checkCategory == null) {
            return "redirect:/admin/allcategory";
        }

        categoryService.removeCategoryById(id);

        return "redirect:/admin/allcategory";
    }

    @GetMapping("/admin/all_user/remove/{uid}")
    public String removeUser(@PathVariable("uid") Long id) {

        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/admin/alluser";
        }

        userService.removeUserById(id);

        return "redirect:/admin/alluser";
    }

    @GetMapping("/admin/all_post/remove/{pid}")
    public String removePost(@PathVariable("pid") Long id) {

        Post post = postService.getPostById(id);
        if (post == null) {
            return "redirect:/admin/allpost";
        }

        postService.removePostById(id);

        return "redirect:/admin/allpost";
    }


    @PostMapping("/admin/all_category/add")
    public String addCategory(Category category) {

        Category checkCategory = categoryService.getCategoryByName(category.getName());
        if (checkCategory != null || category.getName().isEmpty()) {

            return "redirect:/admin/allcategory";
        }

        categoryService.addCategory(category);

        return "redirect:/admin/allcategory";
    }
}
