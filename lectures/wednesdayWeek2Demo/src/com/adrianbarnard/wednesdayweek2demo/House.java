package com.adrianbarnard.wednesdayweek2demo;

public class House {
	/*
	 * Rooms
	 * Number of people
	 * Appliances
	 * Utilities/bills
	 * Exterior color
	 * Address
	 * 
	 * Square footage
	 */
	// Defined four member variables for each House - note the word "private" here
	private int numberOfBedrooms;
	private int squareFootage;
	private String address;
	private String exteriorColor;
	
	// Class variable - using the "static"
	public static String association = "The Happy Spot";
	
	// Suppose we want the flexibility to create a House where we can specify the address, color, etc.
	// What should the very first line be?
	public House() { // Constructor
		this.numberOfBedrooms = 3;
		this.squareFootage = 1200;
		this.address = "123 Main St.";
		this.exteriorColor = "blue";
	}

	// Now allow us to specify what we want for this House
	public House(int numberOfBedrooms, int squareFootage, String address, String exteriorColor) {
		this.numberOfBedrooms = numberOfBedrooms;
		this.squareFootage = squareFootage;
		this.address = address;
		this.exteriorColor = exteriorColor;
	}
	// Methods for a house
	public void cleanHouse() {
		System.out.println("Dusting off house and scrubbing grime off");
	}
	
	public void repaintHouse(String newColor) {
		this.exteriorColor = newColor;
	}
	
	// Getters and setters - auto-generated by us
	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public int getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor;
	}
	
	

}
