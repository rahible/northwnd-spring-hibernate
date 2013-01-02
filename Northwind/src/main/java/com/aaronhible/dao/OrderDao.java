package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Order;

public interface OrderDao {

	public abstract void persist(Order transientInstance);

	public abstract void attachDirty(Order instance);

	public abstract void attachClean(Order instance);

	public abstract void delete(Order persistentInstance);

	public abstract Order merge(Order detachedInstance);

	public abstract Order findById(int id);

	public abstract List<Order> findByExample(Order instance);

}