package com.ajeet.blog.ajeetblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajeet.blog.ajeetblog.payloads.CategoryDto;
import com.ajeet.blog.ajeetblog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createdCatDto = this.categoryService.createCat(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCatDto, HttpStatus.CREATED);
    }
    
}
