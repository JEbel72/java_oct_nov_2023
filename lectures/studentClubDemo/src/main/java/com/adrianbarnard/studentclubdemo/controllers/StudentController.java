package com.adrianbarnard.studentclubdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.adrianbarnard.studentclubdemo.models.Student;
import com.adrianbarnard.studentclubdemo.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentServ;
	
	@GetMapping("/")
	public String rootRoute() {
		return "redirect:/students";
	}
	
	@GetMapping("/students") // Route to show all students
	public String allStudentsPage(Model viewModel) {
		viewModel.addAttribute("allStudents", studentServ.readAllStudents());
		System.out.println(studentServ.readAllStudents());
		return "readAllStudents.jsp";
	}
	
	@GetMapping("/students/new") // GET route to show a form for adding a student
	public String addStudentPage(@ModelAttribute("newStudent") Student newStudent) {
		return "newStudent.jsp";
	}
	
	@PostMapping("/students/new") // Route to process the form
	public String addStudentToDB(@Valid @ModelAttribute("newStudent") Student newStudent,
			BindingResult result) {
		// NOTE: BindingResult must come IMMEDIATELY after @Valid @ModelAttribute
		if (result.hasErrors()) {
			return "newStudent.jsp";
		}
		// Validations are good, so we'll add the student to the database
		studentServ.createStudent(newStudent);
		return "redirect:/students";
	}
	
	// Read ONE student
	@GetMapping("/students/{id}")
	public String readOneStudentPage(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("thisStudent", studentServ.readOneStudent(id));
		return "readOneStudent.jsp";
	}
	
	@GetMapping("/students/{id}/edit") // Show edit form
	public String editOneStudentPage(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("studentToEdit", studentServ.readOneStudent(id));
		return "updateStudent.jsp";
	}
	
	@PutMapping("/students/{id}/edit") // Process edit form
	public String editStudentInDB(@Valid @ModelAttribute("studentToEdit") Student studentToEdit,
			BindingResult result) {
		// NOTE: BindingResult must come IMMEDIATELY after @Valid @ModelAttribute
		if (result.hasErrors()) {
			return "updateStudent.jsp";
		}
		// Validations are good, so we'll add the student to the database
		studentServ.updateStudent(studentToEdit);
		return "redirect:/students/"+studentToEdit.getId();
	}
}
