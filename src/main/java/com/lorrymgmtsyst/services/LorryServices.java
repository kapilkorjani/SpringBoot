package com.lorrymgmtsyst.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorrymgmtsyst.model.Lorry;
import com.lorrymgmtsyst.repository.LorryRepository;

@Service
public class LorryServices {

	
	@Autowired
	private LorryRepository lorryRepository;
	
	public Optional<Lorry> getLorryById(int id) {
		return lorryRepository.findById(id);
	}
	
}
