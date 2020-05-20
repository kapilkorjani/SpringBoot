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
@Table(name = "consigner" , uniqueConstraints = {
		@UniqueConstraint( columnNames = {"consigner_email"})})
public class Consigner {

	@Id
	@GeneratedValue
	private int consignerId;
	@Column(name = "consigner_name" , nullable = false)
	private String consignerName;
	@Column(name = "pickup_address", nullable = false)
	private String pickupAddress;
	@Column(name = "pickup_city" , nullable = false)
	private String pickupCity;
	@Column(name="consigner_email", nullable = false )
	private String consignerEmail;
	@Column(name = "consigner_mobile" , nullable = false, length = 10)
	private String consignerMobile;
	@OneToOne (mappedBy = "consigner")
	private Consignment consignment;
	
}
