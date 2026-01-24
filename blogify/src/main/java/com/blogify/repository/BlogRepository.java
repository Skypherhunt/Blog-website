package com.blogify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogify.model.Blog;
import com.blogify.repository.BlogRepository;
import java.util.*;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByTitleContainingIgnoreCase(String keyword);
    List<Blog> findByUserId(Long userId);
}