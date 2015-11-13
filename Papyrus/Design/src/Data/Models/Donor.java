package Data.Models;

import java.util.List;

public class Donor extends User {

	/**
	 * 
	 */
	public List<UserNotification> userNotification;

	/**
	 * Getter of userNotification
	 */
	public List<UserNotification> getUserNotification() {
	 	 return userNotification; 
	}

	/**
	 * Setter of userNotification
	 */
	public void setUserNotification(List<UserNotification> userNotification) { 
		 this.userNotification = userNotification; 
	} 

}
