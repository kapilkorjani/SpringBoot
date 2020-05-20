package com.lorrymgmtsyst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "user" , uniqueConstraints = {@UniqueConstraint( columnNames =  {"username","password"})})
public class User {
	
	@Id @GeneratedValue
	private int userId;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "email" , nullable = false)
	private String email;
	@Column(name = "mobile", nullable = false, length = 10)
	private String mobile;
}
