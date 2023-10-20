package com.adrianbarnard.starterfullstackproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adrianbarnard.starterfullstackproject.services.TreeService;

@Controller // Don't forget!!
public class TreeController {
	// Inject any needed services here
	@Autowired
	private TreeService treeServ;
	// You must Autowire each service here as necessary
	
	// Define your routes as needed here
}
