package com.hasibur.CareerFootsteps.service.post;

import com.hasibur.CareerFootsteps.model.Comment;
import com.hasibur.CareerFootsteps.model.Post;
import com.hasibur.CareerFootsteps.model.User;

import java.util.List;

public interface PostService {
    public Post addPost(Post post);
    public List<Post> getAllPost();
    public Post getPostById(Long id);
    public List<Post> getPostByUser(User user);
    public void deleteByPostId(Long id);
    public List<Post> getPostBySearch(String sKey);
    //public List<Comment> getAllCommentOfPost();
}
