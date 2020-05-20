package com.lorrymgmtsyst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lorrymgmtsyst.model.Consigner;

@RepositoryRestResource(collectionResourceRel = "consigner" ,path = "consigner")
public interface ConsignerRepository extends JpaRepository<Consigner, Integer>{

}
