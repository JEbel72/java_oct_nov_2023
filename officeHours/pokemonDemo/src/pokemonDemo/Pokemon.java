package pokemonDemo;

import java.util.ArrayList;
import java.util.HashMap;

public class Pokemon {
	/*
	 * Name
	 * Type(s)
	 * HP
	 * Atk
	 * Def
	 * Spd
	 * Level
	 * Moves - name, number of uses, power
	 */
	private String name;
	private int attack;
	private int defense;
	private int maxHP;
	private int currentHP;
	private ArrayList<HashMap<String,Object>> moves;
	
	// Constructor
	public Pokemon(String name, int attack, int defense, int maxHP, int currentHP,
			ArrayList<HashMap<String, Object>> moves) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.maxHP = maxHP;
		this.currentHP = currentHP;
		this.moves = moves;
	}


	public void heal() {
//		// Take the current Pokemon and heal its HP up to the maximum
//		if (this.currentHP != this.maxHP) {
//			int difference = this.maxHP - this.currentHP;
//			this.currentHP += difference;
//		}
		this.currentHP = this.maxHP; // Shorter approach
	}
	
	public void battlePokemon(Pokemon opponent, String moveToUse) {
		// Search for the move
		for (HashMap<String, Object> moveToExamine : this.moves) {
			String moveName = (String) moveToExamine.get("name"); // Grab the name of the move we're looking at
			if (moveName.equals(moveToUse) && (int) moveToExamine.get("usesLeft") > 0) { // If we find the move with the given name AND there is at least one use left, then attack
				System.out.println(opponent.getName() + " has " + opponent.getCurrentHP() + " HP.");
				System.out.println(this.name + " has attacked " + opponent.getName() + " using " + moveToUse);
				int attackPower = (int) moveToExamine.get("basePower"); // Type-cast from Object to an int
				int totalAttackPower = this.attack + attackPower;
				// Grab the defense stat of the opponent
				int defenseStat = opponent.getDefense();
				// Calculate the damage - using the Math.max method to ensure we deal nonnegative damage
				int damage = Math.max(0,totalAttackPower - defenseStat);
				System.out.println(damage + " damage inflicted!");
				// Deduct the damage from the opponent's HP - using the Math.max method to ensure the Pokemon has nonnegative HP
				int newHP = Math.max(0, opponent.getCurrentHP() - damage);
				opponent.setCurrentHP(newHP);
				System.out.println(this.name + " has " + this.currentHP + " HP left.");
				System.out.println(opponent.getName() + " has " + opponent.getCurrentHP() + " HP left.");
				// Decrease the number of uses for this move by one
				int numberOfUsesLeft = (int) moveToExamine.get("usesLeft") - 1;
				moveToExamine.replace("usesLeft", numberOfUsesLeft);
				
				break; // Allow us to exit the loop immediately
			}
		}
	}
	
	// Getters and setters
	public ArrayList<HashMap<String, Object>> getMoves() {
		return moves;
	}
	
	public void setMoves(ArrayList<HashMap<String, Object>> moves) {
		this.moves = moves;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
}
