package com.pint.Data.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usernotification")
public class UserNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long userNotificationId;
	
	public long getUserNotificationId() {
		return userNotificationId;
	}
	
	public void setUserNotificationId(long id){
		this.userNotificationId = id;
	}

	
	@NotNull
	public boolean hasSeen;

	public boolean getHasSeen() {
		return hasSeen; 
	}

	public void setHasSeen(boolean hasSeen) { 
		this.hasSeen = hasSeen; 
	}
	
	@NotNull
	@Column(name = "sentTime", insertable=false)
	private Date sentTime;
	
	public Date getSentTime() {
		return sentTime; 
	}

	public void setSentTime(Date sentTime) { 
		this.sentTime = sentTime; 
	}
	
	
	//@ManyToOne(targetEntity=Donor.class)
	@ManyToOne(targetEntity=Donor.class)
	@JoinColumn(name="email_address")
	private Donor donor;
	
	public Donor getEmailAddress(){
		return donor;
	}
	
	public void setEmailAddress(Donor donor){
		this.donor = donor;
	}
	
	//@ManyToOne(targetEntity=Notification.class)
	@ManyToOne(targetEntity=Notification.class)
	@JoinColumn(name="notification_id")
	private Notification notification;
	
	public Notification getNotificationId() {
		return notification;
	}
	
	public void setNotificationId(Notification notification){
		this.notification = notification;
	}
	

	public UserNotification(){
	}

	public UserNotification(boolean hasSeen, Date sentTime) {
		this.hasSeen = hasSeen;
		this.sentTime = sentTime;

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
