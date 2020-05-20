package com.lorrymgmtsyst.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Consignment {

	@Id @GeneratedValue
	private int consignmentId;
	@OneToOne(fetch = FetchType.EAGER)
	private Consignee consignee;
	@OneToOne(fetch = FetchType.EAGER)
	private Consigner consigner;
	@OneToOne(fetch = FetchType.EAGER)
	private Lorry lorry;
	@OneToOne(fetch = FetchType.EAGER)
	private Driver driver;
	private int consignmentWeight;
	private String consignmentDate;
	
}
