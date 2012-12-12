package com.aaronhible.dao;

import java.util.List;

import com.aaronhible.model.CustomerDemographics;

public interface CustomerDemographicsDao {

	public abstract void persist(CustomerDemographics transientInstance);

	public abstract void attachDirty(CustomerDemographics instance);

	public abstract void attachClean(CustomerDemographics instance);

	public abstract void delete(CustomerDemographics persistentInstance);

	public abstract CustomerDemographics merge(
			CustomerDemographics detachedInstance);

	public abstract CustomerDemographics findById(java.lang.String id);

	public abstract List<CustomerDemographics> findByExample(CustomerDemographics instance);

}