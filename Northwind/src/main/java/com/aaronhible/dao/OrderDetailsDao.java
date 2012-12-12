package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.OrderDetails;

public interface OrderDetailsDao {

	public abstract void persist(OrderDetails transientInstance);

	public abstract void attachDirty(OrderDetails instance);

	public abstract void attachClean(OrderDetails instance);

	public abstract void delete(OrderDetails persistentInstance);

	public abstract OrderDetails merge(OrderDetails detachedInstance);

	public abstract OrderDetails findById(com.aaronhible.model.OrderDetailsId id);

	public abstract List<OrderDetails> findByExample(OrderDetails instance);

}