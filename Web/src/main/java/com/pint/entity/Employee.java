package com.pint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pint.utils.Constants;


@Entity
@Table(name=Constants.EMPLOYEE_TABLE_NAME)
public class Employee {
	@Id
	@NotNull
	private String emailAddress;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String role;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String lastName;
	
	@NotNull
	@Size(min = 1, max = 15)
	private String phoneNumber;
	
	@NotNull
	@Size(min = 1, max = 15)
	private String password;
	
	
	/*@OneToOne(targetEntity=Hospital.class)
	private long hospitalId;*/
	
	@OneToOne(targetEntity=Hospital.class)
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	
	public Employee(){
		
	}
	
	public Employee(String email, String password, String firstName, String lastName, String phoneNo, String role, Hospital hospital){
		this.emailAddress = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNo;
		this.role = role;
		this.hospital = hospital;
	}
	
	public String getEmailAddress(){
		return this.emailAddress;
	}
	
	public void setEmailAddress(String email){
		this.emailAddress = email;
	}
	
	/**
	 * Getter of role
	 */
	public String getRole() {
	 	 return role; 
	}
	/**
	 * Setter of role
	 */
	public void setRole(String role) { 
		 this.role = role; 
	}
	/**
	 * Getter of firstName
	 */
	public String getFirstName() {
	 	 return firstName; 
	}
	/**
	 * Setter of firstName
	 */
	public void setFirstName(String firstName) { 
		 this.firstName = firstName; 
	}
	/**
	 * Getter of lastName
	 */
	public String getLastName() {
	 	 return lastName; 
	}
	/**
	 * Setter of lastName
	 */
	public void setLastName(String lastName) { 
		 this.lastName = lastName; 
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * Getter of hospital
	 */
	public Hospital getHospitalId() {
	 	 return hospital; 
	}
	/**
	 * Setter of hospital
	 */
	public void setHospitalId(Hospital hospital) { 
		 this.hospital = hospital; 
	}
	/**
	 * Getter of phoneNumber
	 */
	public String getPhoneNumber() {
	 	 return phoneNumber; 
	}
	/**
	 * Setter of phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) { 
		 this.phoneNumber = phoneNumber; 
	} 
}
