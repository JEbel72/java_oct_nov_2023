package com.adrianbarnard.songartiststartercode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrianbarnard.songartiststartercode.models.Artist;
import com.adrianbarnard.songartiststartercode.repositories.ArtistRepository;

@Service // DON'T FORGET THIS ANNOTATION!!!
public class ArtistService {
	
	// Long version of injecting our Artist Repository (next line + constructor)
	private final ArtistRepository artistRepo;

	public ArtistService(ArtistRepository artistRepo) {
		this.artistRepo = artistRepo;
	}
	
	// Creating a new Artist
	public Artist createArtist(Artist newArtist) {
		return artistRepo.save(newArtist);
	}
	
	// Grabbing all Artists
	public List<Artist> readAllArtists() {
		return artistRepo.findAll();
	}
	
	// Grabbing one Artist
	public Artist readOneArtist(Long id) {
		Optional<Artist> artistOrNull = artistRepo.findById(id); // Attempt to find the Artist by ID
		// Ternary operator (one-line if statement - "condition ? valueIfTrue : valueIfFalse")
		return artistOrNull.isPresent() ? artistOrNull.get() : null;
	}
	
	// Editing one Artist
	public Artist editArtist(Artist editedArtist) {
		return artistRepo.save(editedArtist);
	}
	
	// Deleting an Artist
	public void deleteArtist(Long id) {
		artistRepo.deleteById(id); // Alternately, you can do .delete(artistToDelete), where you pass in the object itself
	}
	
	// Grab all artists by name in ascending order
	public List<Artist> readAllInAlphabeticalOrder() {
		List<Artist> allArtists = artistRepo.findAllByOrderByNameAsc();
		return allArtists;
	}
	
	// Grab artists that are solo artists
	public List<Artist> findAllSoloArtists() {
		List<Artist> soloArtists = artistRepo.findAllByIsSoloTrue();
		return soloArtists;
	}
}
