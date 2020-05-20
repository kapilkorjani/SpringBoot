package com.lorrymgmtsyst.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lorrymgmtsyst.model.Consignment;
import com.lorrymgmtsyst.model.Driver;
import com.lorrymgmtsyst.model.Lorry;
import com.lorrymgmtsyst.repository.ConsignmentRepository;

@Service
public class ConsignmentServices {

private ConsignmentRepository repo;
	
	public  Consignment addConsignment(Consignment consignment){
		return repo.save(consignment);
	}
	
	public Consignment updateConsignment(Consignment consignment) {
		return repo.save(consignment);
	}
	
	public void deleteConsignment(Consignment consignment) {
		
		repo.delete(consignment);
	}
	
	public List<Consignment> getAllConsignments(){
		return repo.findAll();
	}
	
	public List<Consignment> getConsignmentsByDriver(Driver driver){
		return repo.findAllByDriver(driver);
	}
	
	public List<Consignment>  getConsignmentsByLorry(Lorry lorry){
		return repo.findAllByLorry(lorry);
	}
}
