package com.aaronhible.model;

// Generated Dec 12, 2012 8:51:28 AM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Region generated by hbm2java
 */
public class Region implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int regionId;
	private String regionDescription;
	private Set<Territories> territorieses = new HashSet<Territories>(0);

	public Region() {
	}

	public Region(int regionId, String regionDescription) {
		this.regionId = regionId;
		this.regionDescription = regionDescription;
	}

	public Region(int regionId, String regionDescription,
			Set<Territories> territorieses) {
		this.regionId = regionId;
		this.regionDescription = regionDescription;
		this.territorieses = territorieses;
	}

	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionDescription() {
		return this.regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	public Set<Territories> getTerritorieses() {
		return this.territorieses;
	}

	public void setTerritorieses(Set<Territories> territorieses) {
		this.territorieses = territorieses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + regionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		if (regionId != other.regionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionDescription="
				+ regionDescription + ", territorieses=" + territorieses + "]";
	}

}