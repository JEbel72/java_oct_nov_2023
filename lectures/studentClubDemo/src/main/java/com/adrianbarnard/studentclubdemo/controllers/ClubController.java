package com.adrianbarnard.studentclubdemo.controllers;

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

import com.adrianbarnard.studentclubdemo.models.Club;
import com.adrianbarnard.studentclubdemo.services.ClubService;

import jakarta.validation.Valid;

@Controller
public class ClubController {
	@Autowired
	private ClubService clubServ;
	
	@GetMapping("/clubs") // Route to show all clubs
	public String allClubsPage(Model viewModel) {
		viewModel.addAttribute("allClubs", clubServ.readAllClubs());
		System.out.println(clubServ.readAllClubs());
		return "readAllClubs.jsp";
	}
	
	@GetMapping("/clubs/new") // GET route to show a form for adding a club
	public String addClubPage(@ModelAttribute("newClub") Club newClub) {
		return "newClub.jsp";
	}
	
	@PostMapping("/clubs/new") // Route to process the form
	public String addClubToDB(@Valid @ModelAttribute("newClub") Club newClub,
			BindingResult result) {
		// NOTE: BindingResult must come IMMEDIATELY after @Valid @ModelAttribute
		if (result.hasErrors()) {
			return "newClub.jsp";
		}
		// Validations are good, so we'll add the club to the database
		clubServ.createClub(newClub);
		return "redirect:/clubs";
	}
	
	// Read ONE club
	@GetMapping("/clubs/{id}")
	public String readOneClubPage(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("thisClub", clubServ.readOneClub(id));
		return "readOneClub.jsp";
	}
	
	@GetMapping("/clubs/{id}/edit") // Show edit form
	public String editOneClubPage(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("clubToEdit", clubServ.readOneClub(id));
		return "updateClub.jsp";
	}
	
	@PutMapping("/clubs/{id}/edit") // Process edit form
	public String editClubInDB(@Valid @ModelAttribute("clubToEdit") Club clubToEdit,
			BindingResult result) {
		// NOTE: BindingResult must come IMMEDIATELY after @Valid @ModelAttribute
		if (result.hasErrors()) {
			return "updateClub.jsp";
		}
		// Validations are good, so we'll add the club to the database
		clubServ.updateClub(clubToEdit);
		return "redirect:/clubs/"+clubToEdit.getId(); // Note the ID here so that we redirect to club's page
	}
	
	@DeleteMapping("/clubs/{id}/delete") // Delete club
	public String deleteClubFromDB(@PathVariable("id") Long id) {
		clubServ.deleteClub(id); // Remove club via service
		return "redirect:/clubs"; // Go to all clubs page
	}
}
