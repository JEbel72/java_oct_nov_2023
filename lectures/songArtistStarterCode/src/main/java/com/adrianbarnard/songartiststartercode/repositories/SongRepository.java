package com.adrianbarnard.songartiststartercode.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.songartiststartercode.models.Song;

@Repository // DON'T FORGET THIS ANNOTATION!!!!
public interface SongRepository extends CrudRepository<Song, Long> {
	// Grab all Songs from the database
	List<Song> findAll();

}
