package com.pint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pint.utils.Constants;


@Entity
@Table(name=Constants.NOTIFICATION_TABLE_NAME)
public class Notification{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long notificationId;
	
	public long getId() {
		return notificationId;
	}
	
	public void setId(long id){
		this.notificationId = id;
	}
	
	@NotNull
	@Size(min = 1, max = 200)
	public String title;
	
	public String getTitle() {
		return title; 
	}
	
	public void setTitle(String title) { 
		this.title = title; 
	}
	
	@NotNull
	@Size(min = 1, max = 200)
	public String shortDescription;
	
	public String getShortDescription() {
		return shortDescription; 
	}

	public void setShortDescription(String shortDescription) { 
		this.shortDescription = shortDescription; 
	}
	
	@NotNull
	@Size(min = 1, max = 500)
	public String longDescription;
	
	public String getLongDescription() {
		return longDescription; 
	}
	
	public void setLongDescription(String longDescription) { 
		this.longDescription = longDescription; 
	}
	
	
	@OneToOne(targetEntity=BloodDrive.class)
	@JoinColumn(name="blood_drive_id")
	private BloodDrive bloodDrive;
	
	public BloodDrive getBloodDriveId() {
		return bloodDrive;
	}
	
	public void setBloodDriveId(BloodDrive bloodDrive){
		this.bloodDrive = bloodDrive;
	}
	

	public Notification(){
	}
	
	public Notification(long id, String title, String shortDescription,String longDescription) {
		this.notificationId = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.longDescription= longDescription;
	}

	public String getContent()  {

		/*JSONObject User = new JSONObject();  
		
		User.put("id", 1);
		User.put("emailAddress", "anjlichhatwani"); 
		User.put("state", "achha004@fiu.edu"); 
		return User;
			 */

		return	"title= " + title + " shortDescription :" +shortDescription + " longDescription :" + longDescription ; 
	}
}
