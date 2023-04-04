package com.ajeet.blog.ajeetblog.servicesImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajeet.blog.ajeetblog.entites.Category;
import com.ajeet.blog.ajeetblog.entites.Post;
import com.ajeet.blog.ajeetblog.entites.User;
import com.ajeet.blog.ajeetblog.exceptions.ResourceNotFoundException;
import com.ajeet.blog.ajeetblog.payloads.PostDto;
import com.ajeet.blog.ajeetblog.repos.CateRepo;
import com.ajeet.blog.ajeetblog.repos.PostRepo;
import com.ajeet.blog.ajeetblog.repos.UserRepo;
import com.ajeet.blog.ajeetblog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CateRepo cateRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ", "UserId ", userId));

        Category category = this.cateRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "CategoryId ", userId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setPostImage("default.png");
        post.setCategory(category);
        post.setUser(user);
        post.setCreatedAt(new Date());
        post.setUpdatedAt(new Date());

        Post savedPost = this.postRepo.save(post);

        return this.modelMapper.map(savedPost, PostDto.class);
    }
    
}
