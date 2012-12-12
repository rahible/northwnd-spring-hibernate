package com.aaronhible.model;

// Generated Dec 12, 2012 8:51:28 AM by Hibernate Tools 3.2.2.GA

import java.sql.Blob;

/**
 * Sysdiagrams generated by hbm2java
 */
public class Sysdiagrams implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int diagramId;
	private Integer version;
	private String name;
	private int principalId;
	private Blob definition;

	public Sysdiagrams() {
	}

	public Sysdiagrams(int diagramId, String name, int principalId) {
		this.diagramId = diagramId;
		this.name = name;
		this.principalId = principalId;
	}

	public Sysdiagrams(int diagramId, String name, int principalId,
			Blob definition) {
		this.diagramId = diagramId;
		this.name = name;
		this.principalId = principalId;
		this.definition = definition;
	}

	public int getDiagramId() {
		return this.diagramId;
	}

	public void setDiagramId(int diagramId) {
		this.diagramId = diagramId;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrincipalId() {
		return this.principalId;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}

	public Blob getDefinition() {
		return this.definition;
	}

	public void setDefinition(Blob definition) {
		this.definition = definition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diagramId;
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
		Sysdiagrams other = (Sysdiagrams) obj;
		if (diagramId != other.diagramId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sysdiagrams [diagramId=" + diagramId + ", version=" + version
				+ ", name=" + name + ", principalId=" + principalId
				+ ", definition=" + definition + "]";
	}

}