package com.adrianbarnard.starterfullstackproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.starterfullstackproject.models.Tree;

@Repository // REMEMBER TO ADD THIS!!!
public interface TreeRepository extends CrudRepository<Tree, Long> {
	List<Tree> findAll();
}
