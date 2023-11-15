package com.adrianbarnard.reactbackenddemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianbarnard.reactbackenddemo.services.FairService;

@CrossOrigin(origins="http://localhost:5173") // Allow the React front end to communicate with the back end
@RestController // We will NOT use @Controller as we're serving raw data
public class FairController {
	@Autowired
	private FairService fairServ;
	
	@GetMapping("/")
	public String rootRoute() {
		return "This message is from Spring Boot!";
	}
	
	// We will eventually return data from the database in this demo!!!  Think about how we're going to return this data to the React front end.
}
