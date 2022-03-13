package com.hasibur.CareerFootsteps.service.post;

import com.hasibur.CareerFootsteps.auth.UserInfo;
import com.hasibur.CareerFootsteps.model.Comment;
import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;
import com.hasibur.CareerFootsteps.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    private UserInfo userInfo;

    @Override
    public Post addPost(Post post) {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = localDateTime.format(format);
        post.setTime(formatDateTime);

        User main_user = userInfo.userInfo();
        post.setUser(main_user);


        return postRepo.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public List<Post> getPostByUser(User user) {
        return postRepo.getPostByUser(user);
    }

    @Override
    public void deleteByPostId(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public List<Post> getPostBySearch(String sKey) {
        return postRepo.findBySearchKeyword(sKey);
    }

    @Override
    public void removePostById(Long id) {
        postRepo.deleteById(id);
    }

}
