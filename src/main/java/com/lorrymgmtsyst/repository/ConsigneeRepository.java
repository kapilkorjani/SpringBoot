package com.lorrymgmtsyst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lorrymgmtsyst.model.Consignee;

@RepositoryRestResource(collectionResourceRel = "consignee" ,path = "consignee")
public interface ConsigneeRepository extends JpaRepository<Consignee, Integer>{

}
