package com.nt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		List<Category>categories=categoryRepo.findByIsDeleteFalse();//when we are custom query we remember 1st letter same latter as it is same with model class props
		List<CategoryDto>categoryDtolist = categories.stream().map(cat->mapper.map(cat, CategoryDto.class)).toList();
		return categoryDtolist;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
	List<Category>categories=categoryRepo.findByIsActiveTrueAndIsDeleteFalse();
	List<CategoryResponse> categoryList = categories.stream().map(cate->mapper.map(cate, CategoryResponse.class)).toList();
		return categoryList;
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Optional<Category>findByCategory=categoryRepo.findByIdAndIsDeleteFalse(id);
		if(findByCategory.isPresent())
		{
			Category category=findByCategory.get();
			return mapper.map(category, CategoryDto.class);
		}
		return null;
	}

	@Override
	public Boolean deleteCategoryBy(Integer id) {
		Optional<Category>findByCategory=categoryRepo.findById(id);
		if(findByCategory.isPresent())
		{
			Category category=findByCategory.get();
			category.setIsDelete(true);
			categoryRepo.save(category);
			return true;
		}
		return false;
	}

}
