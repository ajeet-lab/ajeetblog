package com.ajeet.blog.ajeetblog.servicesImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajeet.blog.ajeetblog.entites.Category;
import com.ajeet.blog.ajeetblog.payloads.CategoryDto;
import com.ajeet.blog.ajeetblog.repos.CateRepo;
import com.ajeet.blog.ajeetblog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CateRepo cateRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCat(CategoryDto catDto) {
        Category category = this.modelMapper.map(catDto, Category.class);
        Category saveCat = this.cateRepo.save(category);
        return this.modelMapper.map(saveCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCatDto(CategoryDto catDto, int catId) {
        throw new UnsupportedOperationException("Unimplemented method 'updateCatDto'");
    }

    @Override
    public CategoryDto getCatById(int catId) {
        throw new UnsupportedOperationException("Unimplemented method 'getCatById'");
    }

    @Override
    public List<CategoryDto> getAllCats() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllCats'");
    }

    @Override
    public void deleteCatById(int catId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteCatById'");
    }
    
}
