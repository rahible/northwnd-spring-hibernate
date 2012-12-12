package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Orders;

public interface OrdersDao {

	public abstract void persist(Orders transientInstance);

	public abstract void attachDirty(Orders instance);

	public abstract void attachClean(Orders instance);

	public abstract void delete(Orders persistentInstance);

	public abstract Orders merge(Orders detachedInstance);

	public abstract Orders findById(int id);

	public abstract List<Orders> findByExample(Orders instance);

}