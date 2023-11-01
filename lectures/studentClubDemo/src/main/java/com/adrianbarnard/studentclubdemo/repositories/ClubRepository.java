package com.adrianbarnard.studentclubdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.studentclubdemo.models.Club;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long> {
	List<Club> findAll();
}
