package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Sysdiagrams;

public interface SysDiagramsDao {

	public abstract void persist(Sysdiagrams transientInstance);

	public abstract void attachDirty(Sysdiagrams instance);

	public abstract void attachClean(Sysdiagrams instance);

	public abstract void delete(Sysdiagrams persistentInstance);

	public abstract Sysdiagrams merge(Sysdiagrams detachedInstance);

	public abstract Sysdiagrams findById(int id);

	public abstract List<Sysdiagrams> findByExample(Sysdiagrams instance);

}