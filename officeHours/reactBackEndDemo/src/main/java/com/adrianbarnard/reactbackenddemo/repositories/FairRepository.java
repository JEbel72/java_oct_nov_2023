package com.adrianbarnard.reactbackenddemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.reactbackenddemo.models.Fair;

@Repository
public interface FairRepository extends CrudRepository<Fair, Long> {
	List<Fair> findAll();
}
