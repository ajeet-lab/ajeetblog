package com.ajeet.blog.ajeetblog.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {  
    private int categoryId;
    private String categoryName;
    private String CategoryDescription;
}
