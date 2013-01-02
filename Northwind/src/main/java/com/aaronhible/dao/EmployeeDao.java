package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.Employee;

public interface EmployeeDao {

	public abstract void persist(Employee transientInstance);

	public abstract void attachDirty(Employee instance);

	public abstract void attachClean(Employee instance);

	public abstract void delete(Employee persistentInstance);

	public abstract Employee merge(Employee detachedInstance);

	public abstract Employee findById(int id);

	public abstract List<Employee> findByExample(Employee instance);

}