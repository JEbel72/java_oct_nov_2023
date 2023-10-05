package com.adrianbarnard.wednesdayweek2demo;

public class WednesdayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House boringHouse = new House(2, 1000, "555 Main St.", "blue");
		boringHouse.cleanHouse();
		System.out.println(House.association); // ClassName.classVariable to access a static variable (if it is public)
		// Creating a Mansion
		Mansion opulentMansion = new Mansion(50, 50000, "1000000 Millionaire Way", "black", true, true);
		opulentMansion.cleanHouse();  // Note the behavior of this method!!
	}

}
