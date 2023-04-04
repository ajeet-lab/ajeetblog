package com.ajeet.blog.ajeetblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajeet.blog.ajeetblog.entites.Post;
import com.ajeet.blog.ajeetblog.payloads.PostDto;
import com.ajeet.blog.ajeetblog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
    

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){

      PostDto savePostDto =  this.postService.createPost(postDto, userId, categoryId);

        return new ResponseEntity<PostDto>(savePostDto, HttpStatus.CREATED);

    }
}
