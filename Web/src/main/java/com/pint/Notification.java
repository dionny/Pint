package com.pint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@NotNull
	@Size(min = 1, max = 200)
	public String title;
	
	@NotNull
	@Size(min = 1, max = 200)
	public String shortDescription;
	
	@NotNull
	@Size(min = 1, max = 500)
	public String longDescription;
	
	@OneToOne(targetEntity=BloodDrive.class)
	private long bloodDriveId;

	public Notification(long id, String title, String shortDescription,String longDescription) {
		this.notificationId = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.longDescription= longDescription;
	}

	/**
	 * Getter of title
	 */
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
	 * Getter of shortDescription
	 */
	public String getShortDescription() {
		return shortDescription; 
	}
	/**
	 * Setter of shortDescription
	 */
	public void setShortDescription(String shortDescription) { 
		this.shortDescription = shortDescription; 
	}
	/**
	 * Getter of longDescription
	 */
	public String getLongDescription() {
		return longDescription; 
	}
	/**
	 * Setter of longDescription
	 */
	public void setLongDescription(String longDescription) { 
		this.longDescription = longDescription; 
	}



	public long getId() {
		return notificationId;
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
