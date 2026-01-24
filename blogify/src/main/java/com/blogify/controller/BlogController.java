package com.blogify.controller;

import com.blogify.model.Blog;
import com.blogify.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.*;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public List<Blog> getAllBlogs(@RequestParam(required = false) Integer limit) {
    	if (limit != null) {
            
            return blogRepository.findAll(
                PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "createdAt"))
            ).getContent();
        } else {
            
            return blogRepository.findAll();
        }
    }
    
    @PostMapping
    public String createBlog(@RequestBody Blog blog) {
        if(blog.getTitle() == null || blog.getSubtitle() == null || blog.getContent() == null) {
            return "Title, Subtitle, and Content are required!";
        }
        blogRepository.save(blog);
        return "Blog created successfully!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return blog.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Blog> searchBlogs(@RequestParam String query) {
        return blogRepository.findByTitleContainingIgnoreCase(query);
    }

    @GetMapping("/user/{userId}")
    public List<Blog> getBlogsByUserId(@PathVariable Long userId) {
        return blogRepository.findByUserId(userId);
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long blogId, @RequestBody Blog updatedBlog) {

        return blogRepository.findById(blogId)
            .map(existingBlog -> {

                existingBlog.setTitle(updatedBlog.getTitle());
                existingBlog.setSubtitle(updatedBlog.getSubtitle());
                existingBlog.setContent(updatedBlog.getContent());
                existingBlog.setImageUrl(updatedBlog.getImageUrl());

                Blog savedBlog = blogRepository.save(existingBlog);
                return ResponseEntity.ok(savedBlog);
            })

            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long blogId) {
        return blogRepository.findById(blogId)
            .map(blog -> {
                blogRepository.delete(blog);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}