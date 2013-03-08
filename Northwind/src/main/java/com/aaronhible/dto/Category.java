package com.aaronhible.dto;

import java.io.Serializable;


public class Category implements Serializable {

	private static final long serialVersionUID = -4437555614826438694L;
	private int id;
	private String name;
	private String description;

	public Category(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
