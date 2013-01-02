package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Territory;

public interface TerritoryDao {

	public abstract void persist(Territory transientInstance);

	public abstract void attachDirty(Territory instance);

	public abstract void attachClean(Territory instance);

	public abstract void delete(Territory persistentInstance);

	public abstract Territory merge(Territory detachedInstance);

	public abstract Territory findById(java.lang.String id);

	public abstract List<Territory> findByExample(Territory instance);

}