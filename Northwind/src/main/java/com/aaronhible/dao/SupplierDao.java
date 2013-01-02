package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Supplier;

public interface SupplierDao {

	public abstract void persist(Supplier transientInstance);

	public abstract void attachDirty(Supplier instance);

	public abstract void attachClean(Supplier instance);

	public abstract void delete(Supplier persistentInstance);

	public abstract Supplier merge(Supplier detachedInstance);

	public abstract Supplier findById(int id);

	public abstract List<Supplier> findByExample(Supplier instance);

}