package com.zoo.entity;

public class Zoo {
	Long id;
	String name;
	
	public Zoo(Long id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Zoo() {
	}

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
}
