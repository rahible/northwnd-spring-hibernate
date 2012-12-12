package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Suppliers;

public interface SuppliersDao {

	public abstract void persist(Suppliers transientInstance);

	public abstract void attachDirty(Suppliers instance);

	public abstract void attachClean(Suppliers instance);

	public abstract void delete(Suppliers persistentInstance);

	public abstract Suppliers merge(Suppliers detachedInstance);

	public abstract Suppliers findById(int id);

	public abstract List<Suppliers> findByExample(Suppliers instance);

}