package com.blogify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogify.model.Comment;
import java.util.*;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogId(Long blogId);
}