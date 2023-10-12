package com.adrianbarnard.wednesdayweek3demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // We use @Controller for JSP and other content; @RestController is for raw data, like strings, JSON, etc.
public class MainController {
	@GetMapping("/")
	public String homePage() {
		return "home.jsp";
	}
	
	@GetMapping("/shows")
	public String tvShowsPage(Model model) {
		ArrayList<String> tvShows = new ArrayList<String>();
		tvShows.add("The Price Is Right at Night");
		tvShows.add("Game of Thrones");
		tvShows.add("Better Call Saul");
		tvShows.add("Night Rider");
		tvShows.add("The Voice");
		// Pass in values via the model container - note the variable names in the quotes, as we'll use those
		// in our JSP files!!!!
		model.addAttribute("allShows",tvShows);
		model.addAttribute("pageTitle", "The class's favorite shows");
		return "jspDemo.jsp";
	}
}
