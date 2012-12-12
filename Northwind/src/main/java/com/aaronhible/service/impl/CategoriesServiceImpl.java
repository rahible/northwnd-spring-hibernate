package com.aaronhible.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronhible.dao.CategoriesDao;
import com.aaronhible.model.Categories;
import com.aaronhible.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {
	@Autowired
	private CategoriesDao categoriesDao;
	public List<Categories> findAll() {
		return getCategoriesDao().findAll();
	}
	
	@Override
	public Categories findById(int id) {
		return getCategoriesDao().findById(id);
	}
	
	public byte[] findPicture(int id) {
		return getCategoriesDao().findPicture(id);
	}

	private CategoriesDao getCategoriesDao() {
		return this.categoriesDao;
	}

}
