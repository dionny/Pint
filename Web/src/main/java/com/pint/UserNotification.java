package com.pint;

import com.pint.entity.Donor;
import com.pint.entity.Notification;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usernotification")
public class UserNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long userNotificationId;
	
	@NotNull
	public boolean hasSeen;
	
	@NotNull
	@Column(name = "sentTime", insertable=false)
	private Date sentTime;
	
	
	@ManyToOne(targetEntity=Donor.class)
	private String emailAddress;
	
	@ManyToOne(targetEntity=Notification.class)
	private long notificationId;
	
	
	/**
	 * Getter of hasSeen
	 */
	public boolean getHasSeen() {
		return hasSeen; 
	}
	/**
	 * Setter of hasSeen
	 */
	public void setHasSeen(boolean hasSeen) { 
		this.hasSeen = hasSeen; 
	}
	/**
	 * Getter of sentTime
	 */
	public Date getSentTime() {
		return sentTime; 
	}
	/**
	 * Setter of sentTime
	 */
	public void setSentTime(Date sentTime) { 
		this.sentTime = sentTime; 
	}
	
	/**
	 * 
	 * @param bloodDriveId 
	 * @param userId 
	 */
	public void get(String bloodDriveId, String userId) { 
		// TODO Auto-generated method
	}
	/**
	 * 
	 * @param id 
	 */
	public void get(String userId) { 
		// TODO Auto-generated method
	} 


	public UserNotification(boolean hasSeen, Date sentTime) {
		this.hasSeen = hasSeen;
		this.sentTime = sentTime;

	}


	public long getId() {
		return userNotificationId;
	}

	public String getContent()  {

		/*JSONObject User = new JSONObject();  

    	User.put("id", 1);
    	User.put("emailAddress", "anjlichhatwani"); 
    	User.put("state", "achha004@fiu.edu"); 
    	return User;
		 */

		return	"id :=== " + userNotificationId + " hasSeen :" + hasSeen + " sentTime :" + sentTime  ;
	}



}
