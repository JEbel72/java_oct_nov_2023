package com.adrianbarnard.abstractclassdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="dinosaurs")
public class Dinosaur extends StarterClass {
	private Integer numberOfLegs;
	
	private Boolean isPlantEater;
	
	private Boolean isMeatEater;
	
	private Double height;
	
	private String species;
	
	public Dinosaur() {}

	public Dinosaur(Integer numberOfLegs, Boolean isPlantEater, Boolean isMeatEater, Double height, String species) {
		this.numberOfLegs = numberOfLegs;
		this.isPlantEater = isPlantEater;
		this.isMeatEater = isMeatEater;
		this.height = height;
		this.species = species;
	}

	public Integer getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(Integer numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public Boolean getIsPlantEater() {
		return isPlantEater;
	}

	public void setIsPlantEater(Boolean isPlantEater) {
		this.isPlantEater = isPlantEater;
	}

	public Boolean getIsMeatEater() {
		return isMeatEater;
	}

	public void setIsMeatEater(Boolean isMeatEater) {
		this.isMeatEater = isMeatEater;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
}

