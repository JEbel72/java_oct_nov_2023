package pokemonDemo;

import java.util.ArrayList;
import java.util.HashMap;

public class PokemonTest {

	public static void main(String[] args) {
		// Tackle move
		HashMap<String, Object> tackleMove = new HashMap<String, Object>();
		tackleMove.put("name", "Tackle");
		tackleMove.put("usesLeft", 35);
		tackleMove.put("maxUses", 35);
		tackleMove.put("basePower", 40);
		// Thundershock move
		HashMap<String, Object> thundershockMove = new HashMap<String, Object>();
		thundershockMove.put("name", "Thundershock");
		thundershockMove.put("usesLeft", 35);
		thundershockMove.put("maxUses", 35);
		thundershockMove.put("basePower", 30);
		// Create move sets
		ArrayList<HashMap<String, Object>> eeveeMoves = new ArrayList<HashMap<String, Object>>();
		eeveeMoves.add(tackleMove);
		ArrayList<HashMap<String, Object>> pikachuMoves = new ArrayList<HashMap<String, Object>>();
		pikachuMoves.add(thundershockMove);
		
		
		// Created 2 Pokemon
		Pokemon eevee = new Pokemon("Eevee", 100, 70, 150, 150, eeveeMoves);
		Pokemon pikachu = new Pokemon("Pikachu", 110, 60, 140, 140, pikachuMoves);
		eevee.battlePokemon(pikachu);
	}

}
