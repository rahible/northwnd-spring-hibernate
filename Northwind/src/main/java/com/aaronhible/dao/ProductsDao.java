package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Products;

public interface ProductsDao {

	public abstract void persist(Products transientInstance);

	public abstract void attachDirty(Products instance);

	public abstract void attachClean(Products instance);

	public abstract void delete(Products persistentInstance);

	public abstract Products merge(Products detachedInstance);

	public abstract Products findById(int id);

	public abstract List<Products> findByExample(Products instance);

}