package com.adrianbarnard.tuesdayweek3demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // For serving raw data (like Strings, JSON data, booleans, etc.)
public class FirstController {
	
	@RequestMapping("/") // Root route (default GET request) - localhost:8080
	public String firstRoute() {
		return "This is our first Java web app!";
	}
	
	// Note that "/home" and "/home/" are different routes!
	
	@GetMapping("/home") // GET request route - localhost:8080/home
	public String homeRoute() {
		return "<h1>Welcome home!</h1>";
	}
	
	@GetMapping("/status") // Route is "localhost:8080/status?city=???&years=???"
	public String currentStatus(@RequestParam("city") String city, @RequestParam("years") Long totalYears) {
		return "I lived in " + city + " for " + totalYears + " years"; 
	}
	
	@GetMapping("/games/{gameName}") // Path variables go inside the {} in your route name
	public String bragAboutGame(@PathVariable("gameName") String gameName) {
		return "I love " + gameName + "!";
		
	}
}
