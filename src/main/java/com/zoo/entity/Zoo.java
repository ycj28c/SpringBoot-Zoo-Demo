package com.zoo.entity;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonDeserialize(using = ZooDeserializer.class)
public class Zoo {
	private String name;
	private String address;
	private String website;
	
	@JsonDeserialize(using = ZooDeserializer.class)
	List<Animal> animalsList;
	
	public Zoo() {
	}
	
	public Zoo(String name, String address, String website, List<Animal> animalsList){
		this.name = name;
		this.address = address;
		this.website = website;
		this.animalsList = animalsList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<Animal> getAnimalsList() {
		return animalsList;
	}
	public void setAnimalsList(List<Animal> animalsList) {
		this.animalsList = animalsList;
	}
	
	/** 
	 * update the zoo information from source to destination
	 * @param a
	 * @param b
	 */
	public static void update(Zoo source, Zoo destination){
		if(source.getAddress() != null){
			destination.setAddress(source.getAddress());
		}
		if(source.getName() != null){
			destination.setName(source.getName());
		}
		if(source.getWebsite() != null){
			destination.setWebsite(source.getWebsite());
		}
		if(source.getAnimalsList() != null){
			destination.setAnimalsList(source.getAnimalsList());
		}
	}
}
