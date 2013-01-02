package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.CustomerDemographic;

public interface CustomerDemographicDao {

	public abstract void persist(CustomerDemographic transientInstance);

	public abstract void attachDirty(CustomerDemographic instance);

	public abstract void attachClean(CustomerDemographic instance);

	public abstract void delete(CustomerDemographic persistentInstance);

	public abstract CustomerDemographic merge(
			CustomerDemographic detachedInstance);

	public abstract CustomerDemographic findById(java.lang.String id);

	public abstract List<CustomerDemographic> findByExample(CustomerDemographic instance);

}