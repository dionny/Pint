package com.pint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="hospital")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long hospitalId;
	  
	@NotNull
	@Size(min = 3, max = 200)
	private String hospitalName;
	
	public Hospital(String hospitalName){
		this.hospitalName = hospitalName;
	}
	
	public Hospital(long hospitalId, String hospitalName){
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
	}
	
	public long getId(){
		return hospitalId;
	}
}
