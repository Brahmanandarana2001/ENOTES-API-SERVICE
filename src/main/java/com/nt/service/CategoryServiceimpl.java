package com.nt.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.nt.dto.CategoryDto;
import com.nt.dto.CategoryResponse;
import com.nt.entity.Category;
import com.nt.repository.CategoryRepository;
@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired
private CategoryRepository categoryRepo;
	@Autowired
private ModelMapper mapper;
	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {
		Category category=mapper.map(categoryDto,Category.class);
		category.setIsDelete(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		
		Category saveCategory=categoryRepo.save(category);
		if(ObjectUtils.isEmpty(saveCategory))
		return false;
		else
			return true;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category>categories=categoryRepo.findAll();
		List<CategoryDto>categoryDtolist = categories.stream().map(cat->mapper.map(cat, CategoryDto.class)).toList();
		return categoryDtolist;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
	List<Category>categories=categoryRepo.findByIsActiveTrue();
	List<CategoryResponse> categoryList = categories.stream().map(cate->mapper.map(cate, CategoryResponse.class)).toList();
		return categoryList;
	}

}
