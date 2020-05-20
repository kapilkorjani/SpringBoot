package com.lorrymgmtsyst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "lorry",uniqueConstraints = {@UniqueConstraint(columnNames = {"lorry_registration"})})
public class Lorry {

	@Id @GeneratedValue
	private int lorryId;
	@Column(nullable = false)
	private String lorryName;
	@Column(name = "lorry_registration", nullable = false)
	private String lorryRegistration;
	private int lorryCapacity;
	@OneToOne (mappedBy = "lorry")
	private Consignment consignment;
	
	
}
