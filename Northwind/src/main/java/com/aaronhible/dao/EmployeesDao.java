package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Employees;

public interface EmployeesDao {

	public abstract void persist(Employees transientInstance);

	public abstract void attachDirty(Employees instance);

	public abstract void attachClean(Employees instance);

	public abstract void delete(Employees persistentInstance);

	public abstract Employees merge(Employees detachedInstance);

	public abstract Employees findById(int id);

	public abstract List<Employees> findByExample(Employees instance);

}