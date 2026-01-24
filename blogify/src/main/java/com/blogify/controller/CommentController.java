package com.blogify.controller;

import com.blogify.dto.CommentDto;
import com.blogify.model.Comment;
import com.blogify.model.User;
import com.blogify.repository.CommentRepository;
import com.blogify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/blogs/{blogId}/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<CommentDto> getComments(@PathVariable Long blogId) {
        List<Comment> comments = commentRepository.findByBlogId(blogId);
        List<CommentDto> commentDtos = new ArrayList<>();

        for (Comment comment : comments) {
            User user = userRepository.findById(comment.getUserId()).orElse(null);

            CommentDto dto = new CommentDto();
            dto.setCommentId(comment.getCommentId());
            dto.setCommentText(comment.getCommentText());
            dto.setUsername(user != null ? user.getUsername() : "Anonymous");
            
            commentDtos.add(dto);
        }
        return commentDtos;
    }

    @PostMapping
    public String addComment(@PathVariable Long blogId, @RequestBody Comment comment) {
        if (comment.getCommentText() == null || comment.getCommentText().trim().isEmpty() || comment.getUserId() == null) {
            return "Comment text and userId are required!";
        }
        comment.setBlogId(blogId);
        commentRepository.save(comment);
        return "Comment added successfully!";
    }
}