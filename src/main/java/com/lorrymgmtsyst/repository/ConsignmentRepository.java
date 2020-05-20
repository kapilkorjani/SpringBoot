package com.lorrymgmtsyst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lorrymgmtsyst.model.Consignment;
import com.lorrymgmtsyst.model.Driver;
import com.lorrymgmtsyst.model.Lorry;

@RepositoryRestResource(collectionResourceRel = "consignment" ,path = "consignment")
public interface ConsignmentRepository extends JpaRepository<Consignment, Integer>{

	public List<Consignment> findAllByDriver(Driver driver);
	
	public List<Consignment> findAllByLorry(Lorry lorry);
}
