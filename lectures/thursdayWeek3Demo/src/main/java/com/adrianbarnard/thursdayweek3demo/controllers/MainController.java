package com.adrianbarnard.thursdayweek3demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller // Need this so we can return (serve) our JSP files
public class MainController {

	@GetMapping("/") // Route with our form
	public String homePage() {
		return "home.jsp";
	}
	
//	@RequestMapping(value="/handleform", method=RequestMethod.POST) // Alternate way to say this route is a POST request
	@PostMapping("/handleform")
	public String processForm(
			@RequestParam("team") String team,
			@RequestParam("song") String song,
			@RequestParam("number") String number, // This is still a string because ALL form data comes back as a string!
			@RequestParam("brag") String brag,
			HttpSession session
			) {
		// Saving the values for our form in session so we can use these values elsewhere in the app
		session.setAttribute("teamName", team);
		session.setAttribute("favSong", song);
		session.setAttribute("favNumber", number);
		session.setAttribute("brag", brag);
		return "redirect:/results"; // redirect: , then the name of the route to redirect to
		// Always redirect!!
	}
	
	@GetMapping("/results")
	public String resultsRoute(Model model, HttpSession session) {
		// Grabbing the values from session and saving them into the model so that they're available along with the JSP
		model.addAttribute("teamName", session.getAttribute("teamName"));
		model.addAttribute("favSong", session.getAttribute("favSong"));
		model.addAttribute("number", session.getAttribute("favNumber"));
		model.addAttribute("brag", session.getAttribute("brag"));
		return "results.jsp";
	}
}
