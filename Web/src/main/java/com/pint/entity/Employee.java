package com.pint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="employee")
public class Employee {
	@Id
	@NotNull
	private String emailAddress;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String role;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String fName;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String lName;
	
	@NotNull
	@Size(min = 1, max = 15)
	private String phoneNo;
	
	@NotNull
	@Size(min = 1, max = 15)
	private String password;
	
	@OneToOne(targetEntity=Hospital.class)
	private long hospitalId;
}
