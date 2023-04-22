package com.ajeet.blog.ajeetblog.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajeet.blog.ajeetblog.entites.Category;
import com.ajeet.blog.ajeetblog.entites.Post;
import com.ajeet.blog.ajeetblog.entites.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByCategory(Category category); 
    List<Post> findByUser(User user);  
}
