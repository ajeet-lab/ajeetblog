package com.ajeet.blog.ajeetblog.services;

import java.util.List;

import com.ajeet.blog.ajeetblog.payloads.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePostById(Integer postId, PostDto postDto);

    List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);

    PostDto getPostById(Integer postId);

    List<PostDto> findByUserDto(Integer userId);

    List<PostDto> findByCategoryDto(Integer categoryId);

    void deletePostById(Integer postId);

}
