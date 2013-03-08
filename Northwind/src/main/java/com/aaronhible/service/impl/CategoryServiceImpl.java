package com.aaronhible.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaronhible.dao.CategoryDao;
import com.aaronhible.model.Category;
import com.aaronhible.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	public List<com.aaronhible.dto.Category> findAll() {
		List<com.aaronhible.dto.Category> dtos = new ArrayList<com.aaronhible.dto.Category>();
		for (Category category : getCategoriesDao().findAll()) {
			dtos.add(new com.aaronhible.dto.Category(category.getId(), category.getName(), category.getDescription()));
		}
		return dtos;
	}
	
	@Override
	public Category findById(int id) {
		return getCategoriesDao().findById(id);
	}
	
	public byte[] findPicture(int id) {
		return getCategoriesDao().findPicture(id);
	}

	private CategoryDao getCategoriesDao() {
		return this.categoryDao;
	}

	@Override
	@Transactional	
	public void save(Category category) {
		this.getCategoriesDao().persist(category);
	}

}
