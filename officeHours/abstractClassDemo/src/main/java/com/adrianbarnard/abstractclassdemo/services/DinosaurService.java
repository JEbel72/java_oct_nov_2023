package com.adrianbarnard.abstractclassdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.abstractclassdemo.models.Dinosaur;
import com.adrianbarnard.abstractclassdemo.repositories.DinosaurRepository;

@Service
public class DinosaurService {
	@Autowired
	private DinosaurRepository dinoRepo;
	
	public Dinosaur addDinosaur(Dinosaur newDino) {
		return dinoRepo.save(newDino);
	}
}

