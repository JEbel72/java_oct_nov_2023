package com.adrianbarnard.abstractclassdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.abstractclassdemo.models.Dinosaur;

@Repository
public interface DinosaurRepository extends CrudRepository<Dinosaur, Long> {
	List<Dinosaur> findAll();
}
