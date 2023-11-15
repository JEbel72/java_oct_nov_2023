package com.adrianbarnard.reactbackenddemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.reactbackenddemo.repositories.FairRepository;

@Service
public class FairService {
	@Autowired
	private FairRepository fairRepo;
}
