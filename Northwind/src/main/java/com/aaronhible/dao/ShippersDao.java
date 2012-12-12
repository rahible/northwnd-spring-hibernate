package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Shippers;

public interface ShippersDao {

	public abstract void persist(Shippers transientInstance);

	public abstract void attachDirty(Shippers instance);

	public abstract void attachClean(Shippers instance);

	public abstract void delete(Shippers persistentInstance);

	public abstract Shippers merge(Shippers detachedInstance);

	public abstract Shippers findById(int id);

	public abstract List<Shippers> findByExample(Shippers instance);

}