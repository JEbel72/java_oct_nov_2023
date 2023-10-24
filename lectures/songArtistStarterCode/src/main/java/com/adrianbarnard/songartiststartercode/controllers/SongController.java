package com.adrianbarnard.songartiststartercode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.adrianbarnard.songartiststartercode.models.Song;
import com.adrianbarnard.songartiststartercode.services.SongService;

import jakarta.validation.Valid;

@Repository // Don't forget this annotation!
public class SongController {
	@Autowired
	private SongService songServ;

	/* Routes involving songs */
	@GetMapping("/songs/new") // Page with our songs form
	public String newSongFormPage(@ModelAttribute("newSong") Song newSong, Model model) {
		// Do we need to pass anything in via our model?
		return "newSong.jsp";
	}
	
	@PostMapping("/songs/new") // Route to process adding a song
	public String addSongToDB(@Valid @ModelAttribute("newSong") Song newSong, BindingResult result,
			Model model) {
		// If the validations are no good...
		if (result.hasErrors()) {
			/* If you pass anything in via the Model, you must pass it in again!!! */
			return "newSong.jsp";
		}
		// The validations are good
		Song savedSong = songServ.createSong(newSong); // Talk to the service
		return "redirect:/songs/"+savedSong.getId(); // Redirect to new song's page
	}
	
	@GetMapping("/songs") // Page that shows all songs
	public String showAllSongsPage(Model model) {
		List<Song> allSongs = songServ.readAllSongs(); // Grab all songs from the database via our service (and repo)
		model.addAttribute("allSongs", allSongs);
		return "allSongs.jsp";
	}
	
	@GetMapping("/songs/{id}") // Page that shows ONE song
	public String viewOneSongPage(@PathVariable("id") Long id, Model model) {
		Song thisSong = songServ.readOneSong(id); // Grabbing one song by ID from the database via the service and repo
		model.addAttribute("thisSong", thisSong);
		return "viewSong.jsp";
	}
	
	@GetMapping("/songs/{id}/edit") // Edit PAGE
	public String editSongPage(@PathVariable("id") Long id, Model model) { // NO @ModelAttribute annotation
		Song thisSong = songServ.readOneSong(id); // Grabbing one song by ID from the database via the service and repo
		model.addAttribute("editedSong", thisSong);
		String[] musicGenres = {"Pop", "Country", "Rock", "Metal", "R&B", "Rap"};
		model.addAttribute("allGenres", musicGenres);
		return "editSong.jsp";
	}
	
	@PutMapping("/songs/{id}/edit") // Actually editing the song
	public String editSongInDB(@PathVariable("id") Long id, @Valid @ModelAttribute("editedSong") Song editedSong,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			// Pass in attributes from the model OTHER than the actual object we're editing

			return "editSong.jsp";
		}
		songServ.editSong(editedSong); // Edit song in DB via service and repo
		return "redirect:/songs/" + editedSong.getId(); // Go back to song's page
	}
	
	@DeleteMapping("/songs/{id}/delete") // For deleting a song
	public String songToRemove(@PathVariable("id") Long id) {
		songServ.deleteSong(id); // Delete song from database via service and repo
		return "redirect:/songs";
	}
}
