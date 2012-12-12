package com.aaronhible.service;

import java.util.List;

import com.aaronhible.model.Categories;

public interface CategoriesService {
	public abstract List<Categories> findAll();
	public abstract Categories findById(int id);
	public byte[] findPicture(int id);
}
