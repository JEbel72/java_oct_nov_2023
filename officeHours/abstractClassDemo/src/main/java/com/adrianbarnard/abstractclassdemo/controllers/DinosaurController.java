package com.adrianbarnard.abstractclassdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.adrianbarnard.abstractclassdemo.models.Dinosaur;
import com.adrianbarnard.abstractclassdemo.services.DinosaurService;

import jakarta.validation.Valid;

@Controller
public class DinosaurController {
	@Autowired
	private DinosaurService dinoServ;
	
	@GetMapping("/")
	public String addDinosaurForm(@ModelAttribute("newDino") Dinosaur newDinosaur) {
		return "addDinosaur.jsp";
	}
	
	@PostMapping("/add")
	public String addDinosaurToDatabase(@Valid @ModelAttribute("newDino") Dinosaur newDinosaur, BindingResult result) {
		if (result.hasErrors()) {
			return "addDinosaur.jsp";
		} else {
			dinoServ.addDinosaur(newDinosaur);
			return "redirect:/";
		}
		
	}
}
