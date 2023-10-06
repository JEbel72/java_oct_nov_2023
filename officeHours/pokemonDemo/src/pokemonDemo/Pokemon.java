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
	
	public void battlePokemon(Pokemon opponent) {
		// Grab the attack stat for this Pokemon AND the attack stat for the move
		HashMap<String,Object> attackToUse = this.moves.get(0);
		int attackPower = (int) attackToUse.get("basePower"); // Type-cast from Object to an int
		int totalAttackPower = this.attack + attackPower;
		// Grab the defense stat of the opponent
		int defenseStat = opponent.getDefense();
		// Calculate the damage
		int damage = totalAttackPower - defenseStat;
		// How can we ensure that we don't deal negative damage?
		
		// Deduct the damage from the opponent's HP
		opponent.setCurrentHP(opponent.getCurrentHP() - damage);
		// How can we ensure a Pokemon doesn't go below 0 HP?
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
