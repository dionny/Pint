package Data.Models;

public class UserNotification {

	/**
	 * 
	 */
	public boolean hasSeen;
	/**
	 * 
	 */
	public long sentTime;
	/**
	 * 
	 */
	public User user;
	/**
	 * 
	 */
	public Notification notification;
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
	public long getSentTime() {
	 	 return sentTime; 
	}
	/**
	 * Setter of sentTime
	 */
	public void setSentTime(long sentTime) { 
		 this.sentTime = sentTime; 
	}
	/**
	 * Getter of user
	 */
	public User getUser() {
	 	 return user; 
	}
	/**
	 * Setter of user
	 */
	public void setUser(User user) { 
		 this.user = user; 
	}
	/**
	 * Getter of notification
	 */
	public Notification getNotification() {
	 	 return notification; 
	}
	/**
	 * Setter of notification
	 */
	public void setNotification(Notification notification) { 
		 this.notification = notification; 
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

}
