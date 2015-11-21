package com.pint;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pint.utils.Constants;

@Entity
@Table(name=Constants.BLOODDRIVE_TABLE_NAME)
public class BloodDrive {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public  long bloodDriveId;
	
	@NotNull
	@Size(min = 1, max = 200)
	public  String title;
	
	@NotNull
	@Size(min = 1, max = 500)
	public  String description;
	
	@NotNull
	@Column(name = "startTime", insertable=true)
	public Date startTime;
	
	@NotNull
	@Column(name = "endTime", insertable=true)
	public Date endTime;
	
	@NotNull
	@Size(min = 1, max = 300)
	public String address;
	
	@NotNull
	public  int numberofDonors = 0;
	
	@NotNull
	@Size(min = 1, max = 50)
	public String city;
	
	@NotNull
	@Size(min = 1, max = 50)
	public String state;
	
	@NotNull
	public int zip;
	
	@OneToOne(targetEntity=Hospital.class)
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	
	
	public BloodDrive(){
		
	}


	public BloodDrive(long bloodDriveId, String title, String description,Date startTime, Date endTime,String address,int numberofDonors,String city,String state,int zip) {
		this.bloodDriveId = bloodDriveId;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
		this.numberofDonors = numberofDonors;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public BloodDrive(long bloodDriveId, String title, String description,Date startTime, Date endTime,String address,int numberofDonors,String city,String state,int zip, Hospital hospitalId) {
		this.bloodDriveId = bloodDriveId;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
		this.numberofDonors = numberofDonors;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.hospital = hospitalId;
	}



	public String getContent()  {

		/*JSONObject User = new JSONObject();  

	  	User.put("id", 1);
	  	User.put("emailAddress", "anjlichhatwani"); 
	  	User.put("state", "achha004@fiu.edu"); 
	  	return User;
		 */


		return " title :" + title  + " description :" + description + " startTime :" + startTime + " endTime :" + endTime+ " address :" + address + " numberofDonors :" + numberofDonors + "city :" + city + "state :" + state;
	}

	public String getTitle() {
		return title; 
	}
	/**
	 * Setter of title
	 */
	public void setTitle(String title) { 
		this.title = title; 
	}
	/**
	 * Getter of description
	 */
	public String getDescription() {
		return description; 
	}
	/**
	 * Setter of description
	 */
	public void setDescription(String description) { 
		this.description = description; 
	}
	/**
	 * Getter of startTime
	 */
	public Date getStartTime() {
		return startTime; 
	}
	/**
	 * Setter of startTime
	 */
	public void setStartTime(Date startTime) { 
		this.startTime = startTime; 
	}
	/**
	 * Getter of endTime
	 */
	public Date getEndTime() {
		return endTime; 
	}
	/**
	 * Setter of endTime
	 */
	public void setEndTime(Date endTime) { 
		this.endTime = endTime; 
	}

	public String getAddress() {
		return address; 
	}
	/**
	 * Setter of address
	 */
	public void setAddress(String address) { 
		this.address = address; 
	}
	/**
	 * Getter of numberOfDonors
	 */
	public int getNumberOfDonors() {
		return numberofDonors; 
	}
	/**
	 * Setter of numberOfDonors
	 */
	public void setNumberOfDonors(int numberOfDonors) { 
		this.numberofDonors = numberOfDonors; 
	}
	/**
	 * Getter of id
	 */
	public long getBloodDriveId() {
		return bloodDriveId; 
	}
	/**
	 * Setter of id
	 */
	public void setbloodDriveId(long id) { 
		this.bloodDriveId = id; 
	}
	
	
	
	public String getCity() {
		return city; 
	}
	/**
	 * Setter of city
	 */
	public void setCity(String city) { 
		this.city = city; 
	}
	/**
	 * Getter of state
	 */
	public String getState() {
		return state; 
	}
	/**
	 * Setter of state
	 */
	public void setState(String state) { 
		this.state = state; 
	}
	/**
	 * 
	 */
	
	
	public int getZip() {
		return zip; 
	}
	/**
	 * Setter of state
	 */
	public void setState(int zip) { 
		this.zip = zip; 
	}
	
	public Hospital getHospitalId(){
		return hospital;
	}
	
	public void setHospitalId(Hospital hospitalId){
		this.hospital = hospitalId;
	}
}
