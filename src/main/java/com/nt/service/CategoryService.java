package com.nt.service;

import java.util.List;

import com.nt.dto.CategoryDto;
import com.nt.dto.CategoryResponse;
import com.nt.entity.Category;

public interface CategoryService {
	public Boolean saveCategory(CategoryDto categoryDto);
    public List<CategoryDto>getAllCategory();
	public List<CategoryResponse> getActiveCategory();
	public CategoryDto getCategoryById(Integer id);
	public Boolean deleteCategoryBy(Integer id);
	
}
