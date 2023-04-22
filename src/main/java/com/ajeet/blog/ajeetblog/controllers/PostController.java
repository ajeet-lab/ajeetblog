package com.ajeet.blog.ajeetblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajeet.blog.ajeetblog.payloads.ApiResponse;
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


    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId, @RequestBody PostDto postDto){
      PostDto postDtos = this.postService.updatePostById(postId, postDto);
      return new ResponseEntity<PostDto>(postDtos, HttpStatus.OK);
    }


    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(@RequestParam(value="pageNumber", defaultValue = "0", required = false) Integer pageNumber,
    @RequestParam(value="pageSize", defaultValue = "5", required = false) Integer pageSize
    ){
      List<PostDto> postDtos = this.postService.getAllPosts(pageNumber, pageSize);
      return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
      PostDto postDto = this.postService.getPostById(postId);
      return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }


    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
      List<PostDto> postDtos = this.postService.findByUserDto(userId);
      return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
      List<PostDto> postDtos = this.postService.findByCategoryDto(categoryId);
      return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
      this.postService.deletePostById(postId);
      ApiResponse apiResponse = new ApiResponse("Post deleted succefully", true);
      return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
    
}
