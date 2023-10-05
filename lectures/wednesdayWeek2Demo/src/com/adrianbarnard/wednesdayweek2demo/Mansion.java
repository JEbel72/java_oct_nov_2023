package com.adrianbarnard.wednesdayweek2demo;

public class Mansion extends House {
	private boolean hasBowlingAlley;
	private boolean hasFountain;
	
	public Mansion(int numberOfBedrooms, int squareFootage, String address, 
			String exteriorColor, boolean hasBowlingAlley, boolean hasFountain) {
		super(numberOfBedrooms, squareFootage, address, exteriorColor);

		this.hasBowlingAlley = hasBowlingAlley;
		this.hasFountain = hasFountain;
	}
	
	public Mansion(int numberOfBedrooms, int squareFootage, String address, 
			String exteriorColor) { // Allow defaults for bowlingAlley and fountain
		super(numberOfBedrooms, squareFootage, address, exteriorColor);
		this.hasBowlingAlley = false;
		this.hasFountain = true;
	}
	
	public void cleanHouse() { // Override the cleanHouse method from the House class
		System.out.println("Hiring a company to clean the mansion");
		super.cleanHouse(); // Call on the House's cleanHouse method
	}

	// Getters and setters (don't need for other attributes as we're inheriting those)
	public boolean isHasBowlingAlley() {
		return hasBowlingAlley;
	}

	public void setHasBowlingAlley(boolean hasBowlingAlley) {
		this.hasBowlingAlley = hasBowlingAlley;
	}

	public boolean isHasFountain() {
		return hasFountain;
	}

	public void setHasFountain(boolean hasFountain) {
		this.hasFountain = hasFountain;
	}
	
	
}
