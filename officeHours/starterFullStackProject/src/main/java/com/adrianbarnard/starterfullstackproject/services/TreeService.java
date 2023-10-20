package com.adrianbarnard.starterfullstackproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.starterfullstackproject.repositories.TreeRepository;

@Service // Don't forget this annotation!!
public class TreeService {
	// Inject any repositories here
	@Autowired
	private TreeRepository treeRepo;
	// NOTE: You must Autowire each repository INDIVIDUALLY!!
	
	// Add methods that involve CRUD and talking to the repository here
}
