package com.nt.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.nt.entity.Category;
import com.nt.repository.CategoryRepository;
@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired
private CategoryRepository categoryRepo;
	@Override
	public Boolean saveCategory(Category category) {
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
	public List<Category> getAllCategory() {
		List<Category>categories=categoryRepo.findAll();
		return categories;
	}

}
