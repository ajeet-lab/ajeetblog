package com.ajeet.blog.ajeetblog.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajeet.blog.ajeetblog.entites.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
    
}
