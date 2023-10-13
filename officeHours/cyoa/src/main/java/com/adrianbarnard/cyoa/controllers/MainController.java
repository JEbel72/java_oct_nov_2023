package com.adrianbarnard.cyoa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller // Need this for our file
public class MainController {
	
	@GetMapping("/")
	public String startingPage() { // Redirect to the /start route, where our adventure will begin
		return "redirect:/start";
	}

	@GetMapping("/{action}")
	public String actionRoute(@PathVariable("action") String action, Model model) {
		String story, leftRoute, rightRoute, leftText, rightText;
		// The story will depend on which route we're on
		switch (action) {
		case "start":
			story = "You have left your village and are walking along the main road.  You see an apple tree "
					+ "and you are feeling a little tired.  What do you do when you get to the tree?";
			leftRoute = "lunch";
			leftText = "Sit down and eat lunch";
			rightRoute = "walk";
			rightText = "Keep walking";
			break;
		case "lunch":
			story = "You are eating lunch, and then you notice a stranger pass by who's feeling very hungry.  "
					+ "You still finished your lunch, but you still feel hungry.  What do you do next?";
			leftRoute = "share";
			leftText = "Share food";
			rightRoute = "ignore";
			rightText = "Keep eating and ignore the stranger";
			break;
		case "walk":
			story = "You continue walking down the road, but then your legs start to feel really tired.  "
					+ "So after an hour, you decide to sit down on the grass by the road.  A wild moose is approaching.  What do you do?";
			leftRoute = "flee";
			leftText = "Run as quickly as you can";
			rightRoute = "stay";
			rightText = "Let the moose approach";
			break;
		default:
			story = "";
			leftRoute = "";
			leftText = "";
			rightRoute = "";
			rightText = "";
		}
		// Pass along the story and the links
		model.addAttribute("story", story);
		model.addAttribute("leftRoute", leftRoute);
		model.addAttribute("leftText", leftText);
		model.addAttribute("rightRoute", rightRoute);
		model.addAttribute("rightText", rightText);
		return "home.jsp";
	}
}
