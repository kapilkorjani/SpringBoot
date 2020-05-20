package com.lorrymgmtsyst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lorrymgmtsyst.model.Lorry;

@RepositoryRestResource(collectionResourceRel = "lorry" ,path = "lorry")
public interface LorryRepository extends JpaRepository<Lorry, Integer>{

}
