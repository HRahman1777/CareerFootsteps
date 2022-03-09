package com.hasibur.CareerFootsteps.controller;

import com.hasibur.CareerFootsteps.auth.UserInfo;
import com.hasibur.CareerFootsteps.model.Category;
import com.hasibur.CareerFootsteps.model.Comment;
import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.service.category.CategoryService;
import com.hasibur.CareerFootsteps.service.comment.CommentService;
import com.hasibur.CareerFootsteps.service.post.PostService;
import com.hasibur.CareerFootsteps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Controller
public class PostController {

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    //===========================================
    //=========  Normal Routing - GET  =====>>>>>
    //===========================================

    @GetMapping("/user/allpost")
    public String allPost(Model model) {

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("posts", postService.getAllPost());

        return "all_post.html";
    }

    @GetMapping("/user/single_post/{pid}")
    public String singlePost(@PathVariable("pid") Long id, Model model) {

        model.addAttribute("singlePost", postService.getPostById(id));
        model.addAttribute("comment_form", new Comment());
        model.addAttribute("comments", postService.getPostById(id).getCommentList());
        model.addAttribute("mainUserId", userInfo.userInfo().getId());

        return "single_post.html";
    }

    @GetMapping("/user/single_post/{pid}/delete")
    public String deletePost(@PathVariable("pid") Long pstId) {

        Long chekId = postService.getPostById(pstId).getUser().getId();


        if (Objects.equals(chekId, userInfo.userInfo().getId())) {
            try {

                postService.deleteByPostId(pstId);
            } catch (Exception ex) {
                System.out.println("Post Delete Exception: " + ex);
            }
        }

        return "redirect:/user/home";
    }

    @GetMapping("/user/single_post/{pid}/comment/{cid}/delete")
    public String deleteComment(@PathVariable("cid") Long cmntId, @PathVariable("pid") Long pstId) {
        Long chekId = commentService.getCommentById(cmntId).getUser().getId();

        if (Objects.equals(chekId, userInfo.userInfo().getId())) {
            try {
                commentService.deleteByCommentId(cmntId);
            } catch (Exception ex) {
                System.out.println("Comment Delete Exception: " + ex);
            }
        }

        return "redirect:/user/single_post/" + pstId;
    }

    @GetMapping("/user/allpost/")
    public String allCategoryPost(@RequestParam Long catId, Model model) {

        if (catId != null) {
            try {
                List<Post> newPostListCat = categoryService.getCategoryById(catId).getPostList();
                model.addAttribute("posts", newPostListCat);
                model.addAttribute("catSelect", catId);
            }catch(Exception ex){
                System.out.println("Exception Finding PostList by CategoryId: " + ex);
                return "redirect: /user/allpost";
            }
        } else {
            return "redirect: /user/allpost";
        }

        model.addAttribute("categories", categoryService.getAllCategory());
        return "all_post.html";
    }

    @GetMapping("/user/allpost/category/{cid}")
    public String postByCategory(@PathVariable("cid") Long catId, Model model) {

        if (catId != null) {
            try {
                List<Post> newPostListCat = categoryService.getCategoryById(catId).getPostList();
                model.addAttribute("posts", newPostListCat);
                model.addAttribute("catSelect", catId);
            }catch(Exception ex){
                System.out.println("Exception Finding PostList by CategoryId: " + ex);
                return "redirect: /user/allpost";
            }
        } else {
            return "redirect: /user/allpost";
        }

        model.addAttribute("categories", categoryService.getAllCategory());
        return "all_post.html";
    }

    @GetMapping("/user/allpost/search/")
    public String allCategoryPost(@RequestParam String sKey, Model model) {
        if (sKey != null ){
            try {
                List<Post> newPostListSer = postService.getPostBySearch(sKey);
                model.addAttribute("posts", newPostListSer);
                model.addAttribute("sKeyChk", sKey);
            }catch(Exception ex){
                System.out.println("Exception Finding PostList by SearchKW: " + ex);
                return "redirect: /user/allpost";
            }
        } else {
            return "redirect: /user/allpost";
        }

        model.addAttribute("categories", categoryService.getAllCategory());

        return "all_post.html";
    }


    //===========================================
    //=========    MAIN POST Mapping   =====>>>>>
    //===========================================

    @PostMapping("/user/posted") //for home and user profile (need to handle ***)
    public String userPosted(@Valid Post post, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "home.html";
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = localDateTime.format(format);
        post.setTime(formatDateTime);

        User main_user = userInfo.userInfo();
        post.setUser(main_user);

        postService.addPost(post);

        return "redirect:/user/home";
    }

    @PostMapping("/user/post/comment/{pid}")
    public String addComment(@PathVariable("pid") Long pid, @Valid Comment comment, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/user/single_post/" + pid;
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = localDateTime.format(format);
        comment.setTime(formatDateTime);

        User main_user = userInfo.userInfo();
        comment.setUser(main_user);

        comment.setPost(postService.getPostById(pid));

        commentService.addComment(comment);
        return "redirect:/user/single_post/" + pid;
    }


}
