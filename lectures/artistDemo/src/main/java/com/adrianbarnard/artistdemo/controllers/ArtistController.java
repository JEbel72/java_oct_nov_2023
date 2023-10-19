package com.adrianbarnard.artistdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.adrianbarnard.artistdemo.models.Artist;
import com.adrianbarnard.artistdemo.services.ArtistService;

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
	
	// Thursday: add a post route for processing the form (also called "/artists/new")
}
