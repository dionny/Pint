package com.pint;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.pint.utils.Constants;


@Entity
@Table(name=Constants.DONOR_TABLE_NAME)
public class Donor {
	@Id
	@NotNull
	@NotBlank
	@Size(min = 1, max = 100)
	private String emailAddress;
	
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 200)
	private String sessionKey;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 50)
	private String city;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 50)
	private String state;
	
	@NotNull
	private int zip;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 50)
	private String country;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 200)
	private String hashedPassword;
	
	@NotNull
	private int maxFailures = 3;
	
	@NotNull
	private int failCounter;
	
	@NotNull
	@Column(name = "firstFailTime", insertable=false)
	private Date firstFailTime;
}
