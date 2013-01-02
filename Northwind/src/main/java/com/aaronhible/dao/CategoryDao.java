package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Category;

public interface CategoryDao {

	public abstract void persist(Category transientInstance);

	public abstract void attachDirty(Category instance);

	public abstract void attachClean(Category instance);

	public abstract void delete(Category persistentInstance);

	public abstract Category merge(Category detachedInstance);

	public abstract Category findById(int id);

	public abstract List<Category> findByExample(Category instance);
	
	public abstract List<Category> findAll();
	
	public abstract byte[] findPicture(int id);

}