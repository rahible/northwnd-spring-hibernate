package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Territories;

public interface TerritoriesDao {

	public abstract void persist(Territories transientInstance);

	public abstract void attachDirty(Territories instance);

	public abstract void attachClean(Territories instance);

	public abstract void delete(Territories persistentInstance);

	public abstract Territories merge(Territories detachedInstance);

	public abstract Territories findById(java.lang.String id);

	public abstract List<Territories> findByExample(Territories instance);

}