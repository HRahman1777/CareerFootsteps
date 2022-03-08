package com.hasibur.CareerFootsteps.service.comment;

import com.hasibur.CareerFootsteps.model.Comment;

import java.util.List;

public interface CommentService {
    public Comment addComment(Comment comment);
    public List<Comment> getAllComment();
    public void deleteByCommentId(Long id);
    public Comment getCommentById(Long id);
}
