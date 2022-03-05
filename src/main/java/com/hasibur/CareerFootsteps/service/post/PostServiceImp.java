package com.hasibur.CareerFootsteps.service.post;

import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    PostRepo postRepo;

    @Override
    public Post addPost(Post post) {
        return postRepo.save(post);
    }
}
