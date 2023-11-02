package com.adrianbarnard.studentclubdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.studentclubdemo.models.Club;
import com.adrianbarnard.studentclubdemo.models.Student;
import com.adrianbarnard.studentclubdemo.repositories.ClubRepository;
import com.adrianbarnard.studentclubdemo.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ClubRepository clubRepo;
	
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
	
	// Delete one student
	public void deleteStudent(Long id) {
		// Grab the Student
		Student thisStudent = this.readOneStudent(id);
		/* IMPORTANT: Remove all connections to the student before deleting! */
		// Remove all the clubs from this student - but the clubs will NOT be deleted; just the connections between this student and the club
		for (Club thisClub : thisStudent.getEnrolledClubs()) {
			thisClub.getEnrolledStudents().remove(thisStudent); // Remove the student from the club
			clubRepo.save(thisClub); // Save updated club with the student removed
		}
		studentRepo.deleteById(id); // alternately do studentRepo.delete(thisStudent)
	}
	
	// Add a student to a club
	public void addStudentToClub(Long studentId, Long clubId) {
		Student thisStudent = this.readOneStudent(studentId); // Grab Student object
		Optional<Club> possibleClub = clubRepo.findById(clubId);
		Club thisClub = possibleClub.get(); // You can the present check here, but I chose not to include it due to time
		thisStudent.getEnrolledClubs().add(thisClub);
		studentRepo.save(thisStudent); // Save the student with the list of clubs updated
	}
	
	// Remove student from club
	public void removeStudentFromClub(Long studentId, Long clubId) {
		Student thisStudent = this.readOneStudent(studentId); // Grab Student object
		Optional<Club> possibleClub = clubRepo.findById(clubId);
		Club thisClub = possibleClub.get(); // You can the present check here, but I chose not to include it due to time
		thisStudent.getEnrolledClubs().remove(thisClub); // Remove connnection between the student and club
		studentRepo.save(thisStudent); // Save the student with the list of clubs updated
	}
	
	// Grab students NOT in a club
	public List<Student> readStudentsNotInClub(Club club) {
		return studentRepo.findAllByEnrolledClubsNotContaining(club);
	}
	
}
