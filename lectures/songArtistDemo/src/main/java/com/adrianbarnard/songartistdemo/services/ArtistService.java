package com.adrianbarnard.songartistdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.songartistdemo.models.Artist;
import com.adrianbarnard.songartistdemo.models.Song;
import com.adrianbarnard.songartistdemo.repositories.ArtistRepository;
import com.adrianbarnard.songartistdemo.repositories.SongRepository;

@Service // DON'T FORGET THIS ANNOTATION!!!
public class ArtistService {
	// Short version of injecting
	@Autowired
	private SongRepository songRepo;
	
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
		Artist thisArtist = this.readOneArtist(id); // Grab artist firwst
		// Now we're going to delete all songs linked to the Artist
		int numberOfSongs = thisArtist.getSongs().size();
		for (int i = 0; i < numberOfSongs; i++) {
			Song thisSong = thisArtist.getSongs().remove(i); // Remove song from list
			songRepo.delete(thisSong); // Remove the song from the database via the song repository
		}
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
