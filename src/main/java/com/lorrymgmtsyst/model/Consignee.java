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
@Table( name = "consignee" , uniqueConstraints = {
		@UniqueConstraint( columnNames = {"consignee_email"})
})
public class Consignee {

	@Id
	@GeneratedValue
	private int consigneeId;
	@Column(name = "consignee_name" , nullable = false)
	private String consigneeName;
	@Column(name = "dropoff_address", nullable = false)
	private String dropoffAddress;
	@Column(name = "dropoff_city" , nullable = false)
	private String dropoffCity;
	@Column(name="consignee_email", nullable = false )
	private String consigneeEmail;
	@Column(name = "consignee_mobile" , nullable = false, length = 10)
	private String consigneeMobile;
	@OneToOne (mappedBy = "consignee")
	private Consignment consignment;
	
}
