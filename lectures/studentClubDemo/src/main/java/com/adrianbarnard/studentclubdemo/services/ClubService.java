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
public class ClubService {
	@Autowired
	private ClubRepository clubRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	// Create club in the database
	public Club createClub(Club newClub) {
		return clubRepo.save(newClub); // Save the new club in the DB
	}
	
	// Read all clubs from the database
	public List<Club> readAllClubs() { 
		return clubRepo.findAll();
	}
	
	// Read one club
	public Club readOneClub(Long id) {
		Optional<Club> possibleClub = clubRepo.findById(id);
		return possibleClub.isPresent() ? possibleClub.get() : null; 
	}
	
	// Update one club
	public Club updateClub(Club clubToEdit) {
		return clubRepo.save(clubToEdit);
	}
	
	// Delete one club
	public void deleteClub(Long id) {
		Club thisClub = this.readOneClub(id); // Grab the club
		// Now remove students from club (but don't delete the students themselves!)
		for (Student thisStudent : thisClub.getEnrolledStudents()) {
			thisStudent.getEnrolledClubs().remove(thisClub); // Remove student from club
			studentRepo.save(thisStudent); // Save changes for student in database
		}
		clubRepo.deleteById(id);
	}
	
	// Read clubs that do NOT have a specific student
	public List<Club> readClubsWithoutStudent(Student student) {
		return clubRepo.findAllByEnrolledStudentsNotContaining(student);
	}
}
