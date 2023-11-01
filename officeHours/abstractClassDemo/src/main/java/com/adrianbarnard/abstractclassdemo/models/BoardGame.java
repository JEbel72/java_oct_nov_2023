package com.adrianbarnard.abstractclassdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="games")
public class BoardGame extends StarterClass {
	
	private Boolean isTurnBased;
	private Boolean usesDice;
	private Integer minimumAge;
	private String name;
	
	public BoardGame() {}
	
	public BoardGame(Boolean isTurnBased, Boolean usesDice, Integer minimumAge, String name) {
		this.isTurnBased = isTurnBased;
		this.usesDice = usesDice;
		this.minimumAge = minimumAge;
		this.name = name;
	}

	public Boolean getIsTurnBased() {
		return isTurnBased;
	}

	public void setIsTurnBased(Boolean isTurnBased) {
		this.isTurnBased = isTurnBased;
	}

	public Boolean getUsesDice() {
		return usesDice;
	}

	public void setUsesDice(Boolean usesDice) {
		this.usesDice = usesDice;
	}

	public Integer getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(Integer minimumAge) {
		this.minimumAge = minimumAge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

