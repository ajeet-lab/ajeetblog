package com.ajeet.blog.ajeetblog.services;

import com.ajeet.blog.ajeetblog.payloads.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
}
