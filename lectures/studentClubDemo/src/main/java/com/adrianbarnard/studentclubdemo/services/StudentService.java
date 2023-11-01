package com.adrianbarnard.studentclubdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.studentclubdemo.models.Student;
import com.adrianbarnard.studentclubdemo.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	// Create student in the database
	public Student createStudent(Student newStudent) {
		return studentRepo.save(newStudent); // Save the new student in the DB
	}
	
	// Read all students from the database
	public List<Student> readAllStudents() {
		return studentRepo.findAll();
	}
	
	// Read one student
	public Student readOneStudent(Long id) {
		Optional<Student> possibleStudent = studentRepo.findById(id);
		return possibleStudent.isPresent() ? possibleStudent.get() : null; 
	}
	
	// Update one student
	public Student updateStudent(Student studentToEdit) {
		return studentRepo.save(studentToEdit);
	}
}
