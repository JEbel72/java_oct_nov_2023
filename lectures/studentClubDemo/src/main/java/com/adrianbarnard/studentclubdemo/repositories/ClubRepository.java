package com.adrianbarnard.studentclubdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.studentclubdemo.models.Club;
import com.adrianbarnard.studentclubdemo.models.Student;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long> {
	List<Club> findAll();
	// JPA query to grab the clubs a student has NOT joined
	List<Club> findAllByEnrolledStudentsNotContaining(Student student);
}
