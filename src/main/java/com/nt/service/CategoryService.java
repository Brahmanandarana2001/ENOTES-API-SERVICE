package com.nt.service;

import java.util.List;

import com.nt.entity.Category;

public interface CategoryService {
	public Boolean saveCategory(Category category);
    public List<Category>getAllCategory();
}
