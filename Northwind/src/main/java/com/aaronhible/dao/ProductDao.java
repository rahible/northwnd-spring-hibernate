package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Product;

public interface ProductDao {

	public abstract void persist(Product transientInstance);

	public abstract void attachDirty(Product instance);

	public abstract void attachClean(Product instance);

	public abstract void delete(Product persistentInstance);

	public abstract Product merge(Product detachedInstance);

	public abstract Product findById(int id);

	public abstract List<Product> findByExample(Product instance);

}