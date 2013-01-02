package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Customer;

public interface CustomerDao {

	public abstract void persist(Customer transientInstance);

	public abstract void attachDirty(Customer instance);

	public abstract void attachClean(Customer instance);

	public abstract void delete(Customer persistentInstance);

	public abstract Customer merge(Customer detachedInstance);

	public abstract Customer findById(java.lang.String id);

	public abstract List<Customer> findByExample(Customer instance);

}