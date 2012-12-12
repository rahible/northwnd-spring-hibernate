package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Region;

public interface RegionDao {

	public abstract void persist(Region transientInstance);

	public abstract void attachDirty(Region instance);

	public abstract void attachClean(Region instance);

	public abstract void delete(Region persistentInstance);

	public abstract Region merge(Region detachedInstance);

	public abstract Region findById(int id);

	public abstract List<Region> findByExample(Region instance);

}