package com.pint.entity;

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
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public void setEmailAddress(String email){
		this.emailAddress = email;
	}
	
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 200)
	private String sessionKey;
	
	public void setSessionKey(String sessionkey){
		this.sessionKey = sessionkey;
	}
	
	public String getSessionKey(){
		return sessionKey;
	}
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 50)
	private String city;
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getCity(){
		return city;
	}
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 50)
	private String state;
	
	public void setState(String state){
		this.state = state;
	}
	
	public String getState(){
		return state;
	}
	
	@NotNull
	private int zip;
	
	public void setZip(int zip){
		this.zip = zip;
	}
	
	public int getZip(){
		return zip;
	}
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 50)
	private String country;
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public String getCountry(){
		return country;
	}
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 200)
	private String hashedPassword;
	
	public void setHashedPassword(String hashedPassword){
		this.hashedPassword = hashedPassword;
	}
	
	public String getHashedPassword(){
		return hashedPassword;
	}
	
	@NotNull
	private int maxFailures = 3;
	
	public void setMaxFailures(int maxFailures){
		this.maxFailures = maxFailures;
	}
	
	public int getMaxFailures(){
		return maxFailures;
	}
	
	@NotNull
	private int failCounter;
	
	public void setFailCounter(int failCounter){
		this.failCounter = failCounter;
	}
	
	public int getFailCounter(){
		return failCounter;
	}
	
	
	@NotNull
	@Column(name = "firstFailTime", insertable=false)
	private Date firstFailTime;
	
	public void setFirstFailTime(Date firstFailTime){
		this.firstFailTime = firstFailTime;
	}
	
	public Date getFirstFailTime(){
		return firstFailTime;
	}
}
