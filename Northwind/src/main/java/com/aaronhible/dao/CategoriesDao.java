package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Categories;

public interface CategoriesDao {

	public abstract void persist(Categories transientInstance);

	public abstract void attachDirty(Categories instance);

	public abstract void attachClean(Categories instance);

	public abstract void delete(Categories persistentInstance);

	public abstract Categories merge(Categories detachedInstance);

	public abstract Categories findById(int id);

	public abstract List<Categories> findByExample(Categories instance);

}