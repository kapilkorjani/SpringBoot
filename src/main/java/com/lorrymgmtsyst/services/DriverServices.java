package com.lorrymgmtsyst.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorrymgmtsyst.model.Driver;
import com.lorrymgmtsyst.repository.DriverRepository;

@Service
public class DriverServices {

	@Autowired
	private DriverRepository driverRepository;
	
	public Optional<Driver> getDriverById(int id) {
		return driverRepository.findById(id);
	}
	
	
}
