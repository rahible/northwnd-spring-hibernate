package com.aaronhible.model;

// Generated Dec 12, 2012 8:51:28 AM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Shippers generated by hbm2java
 */
public class Shippers implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shipperId;
	private String companyName;
	private String phone;
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public Shippers() {
	}

	public Shippers(int shipperId, String companyName) {
		this.shipperId = shipperId;
		this.companyName = companyName;
	}

	public Shippers(int shipperId, String companyName, String phone,
			Set<Orders> orderses) {
		this.shipperId = shipperId;
		this.companyName = companyName;
		this.phone = phone;
		this.orderses = orderses;
	}

	public int getShipperId() {
		return this.shipperId;
	}

	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shipperId;
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
		Shippers other = (Shippers) obj;
		if (shipperId != other.shipperId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shippers [shipperId=" + shipperId + ", companyName="
				+ companyName + ", phone=" + phone + ", orderses=" + orderses
				+ "]";
	}

}
