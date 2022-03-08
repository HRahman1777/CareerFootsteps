package com.hasibur.CareerFootsteps.service.comment;

import com.hasibur.CareerFootsteps.model.Comment;
import com.hasibur.CareerFootsteps.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepo.findAll();
    }

    @Override
    public void deleteByCommentId(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepo.getById(id);
    }
}
