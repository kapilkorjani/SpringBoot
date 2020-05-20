package com.lorrymgmtsyst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lorrymgmtsyst.model.Driver;

@RepositoryRestResource(collectionResourceRel = "driver" ,path = "driver")
public interface DriverRepository extends JpaRepository<Driver, Integer>{

}
