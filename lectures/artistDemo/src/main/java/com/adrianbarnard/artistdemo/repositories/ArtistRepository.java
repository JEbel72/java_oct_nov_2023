package com.adrianbarnard.artistdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.artistdemo.models.Artist;

@Repository // DON'T FORGET THIS ANNOTATION!!!!
public interface ArtistRepository extends CrudRepository<Artist, Long> {
	// Grab all Artists from the database
	List<Artist> findAll();
	
	// Grab all Artists by name in ascending order (A to Z)
	List<Artist> findAllByOrderByNameAsc(); // Correct method is "findAllByOrderByNameAsc()"; didn't include the first "By" originally (which was a mistake)
	
	// Grab all Artists who are solo artists
	List<Artist> findAllByIsSoloTrue();
}
