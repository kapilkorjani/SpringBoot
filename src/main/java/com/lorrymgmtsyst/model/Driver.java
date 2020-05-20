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
@Table(name = "driver",uniqueConstraints = {@UniqueConstraint(columnNames = {"driver_email"})})
public class Driver {

	@Id @GeneratedValue
	private int driverId;
	@Column(nullable = false)
	private String driverName;
	@Column(nullable = false)
	private String driverNumber;
	@Column(name = "driver_email" , nullable = false)
	private String driverEmail;
	@OneToOne (mappedBy = "driver")
	private Consignment consignment;
	
}
