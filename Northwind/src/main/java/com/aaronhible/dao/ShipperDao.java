package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Shipper;

public interface ShipperDao {

	public abstract void persist(Shipper transientInstance);

	public abstract void attachDirty(Shipper instance);

	public abstract void attachClean(Shipper instance);

	public abstract void delete(Shipper persistentInstance);

	public abstract Shipper merge(Shipper detachedInstance);

	public abstract Shipper findById(int id);

	public abstract List<Shipper> findByExample(Shipper instance);

}