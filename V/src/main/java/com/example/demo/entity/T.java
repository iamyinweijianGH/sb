package com.example.demo.entity;

import java.io.Serializable;

public class T implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4896258294655286195L;

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
