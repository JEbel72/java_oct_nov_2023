package com.adrianbarnard.artistdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.adrianbarnard.artistdemo.models.Artist;
import com.adrianbarnard.artistdemo.services.ArtistService;

import jakarta.validation.Valid;

@Controller // Don't forget!!
public class ArtistController {
	@Autowired // Short-hand version of dependency injection
	private ArtistService artistServ;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/artists"; // Redirect to all artists route (NOT created yet)
	}
	
	@GetMapping("/artists/new") // Page with our artist form
	public String newArtistFormPage(@ModelAttribute("newArtist") Artist newArtist, Model model) {
		// Fixed array of genres for music (feel free to use an ArrayList instead)
		String[] musicGenres = {"Pop", "Country", "Rock", "Metal", "R&B", "Rap"};
		model.addAttribute("allGenres", musicGenres);
		return "newArtist.jsp";
	}
	
	@PostMapping("/artists/new") // Route to process adding an artist
	public String addArtistToDB(@Valid @ModelAttribute("newArtist") Artist newArtist, BindingResult result,
			Model model) {
		// If the validations are no good...
		if (result.hasErrors()) {
			/* If you pass anything in via the Model, you must pass it in again!!! */
			String[] musicGenres = {"Pop", "Country", "Rock", "Metal", "R&B", "Rap"};
			model.addAttribute("allGenres", musicGenres);
			return "newArtist.jsp";
		}
		// The validations are good
		artistServ.createArtist(newArtist); // Talk to the service
		return "redirect:/artists";
	}
	
	@GetMapping("/artists") // Page that shows all artists
	public String showAllArtistsPage(Model model) {
		List<Artist> allArtists = artistServ.readAllArtists(); // Grab all artists from the database via our service (and repo)
		model.addAttribute("allArtists", allArtists);
		return "allArtists.jsp";
	}
	
	@GetMapping("/artists/{id}") // Page that shows ONE artist
	public String viewOneArtistPage(@PathVariable("id") Long id, Model model) {
		Artist thisArtist = artistServ.readOneArtist(id); // Grabbing one artist by ID from the database via the service and repo
		model.addAttribute("thisArtist", thisArtist);
		return "viewOneArtist.jsp";
	}
	
	@GetMapping("/artists/{id}/edit") // Edit PAGE
	public String editArtistPage(@PathVariable("id") Long id, Model model) { // NO @ModelAttribute annotation
		Artist thisArtist = artistServ.readOneArtist(id); // Grabbing one artist by ID from the database via the service and repo
		model.addAttribute("artistToEdit", thisArtist);
		String[] musicGenres = {"Pop", "Country", "Rock", "Metal", "R&B", "Rap"};
		model.addAttribute("allGenres", musicGenres);
		return "editArtist.jsp";
	}
	
	@PutMapping("/artists/{id}/edit") // Actually editing the artist
	public String editArtistInDB(@PathVariable("id") Long id, @Valid @ModelAttribute("artistToEdit") Artist editedArtist,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			// Pass in attributes from the model OTHER than the actual object we're editing
			String[] musicGenres = {"Pop", "Country", "Rock", "Metal", "R&B", "Rap"};
			model.addAttribute("allGenres", musicGenres);
			return "editArtist.jsp";
		}
		artistServ.editArtist(editedArtist); // Edit artist in DB via service and repo
		return "redirect:/artists/" + editedArtist.getId(); // Go back to artist's page
	}
	
	@DeleteMapping("/artists/{id}/delete") // For deleting an artist
	public String artistToDelete(@PathVariable("id") Long id) {
		artistServ.deleteArtist(id); // Delete artist from database via service and repo
		return "redirect:/artists";
	}
}
