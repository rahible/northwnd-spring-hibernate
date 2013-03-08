package com.aaronhible.service;

import java.util.List;

import com.aaronhible.model.Category;

public interface CategoryService {
	public abstract List<com.aaronhible.dto.Category> findAll();
	public abstract Category findById(int id);
	public abstract byte[] findPicture(int id);
	public abstract void save(Category category);
}
