package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Customers;

public interface CustomersDao {

	public abstract void persist(Customers transientInstance);

	public abstract void attachDirty(Customers instance);

	public abstract void attachClean(Customers instance);

	public abstract void delete(Customers persistentInstance);

	public abstract Customers merge(Customers detachedInstance);

	public abstract Customers findById(java.lang.String id);

	public abstract List<Customers> findByExample(Customers instance);

}