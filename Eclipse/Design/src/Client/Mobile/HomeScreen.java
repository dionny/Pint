package Client.Mobile;

import Data.Models.User;
import Data.Models.BloodDrive;
import java.util.List;
import Data.Models.Notification;

public class HomeScreen extends MobileScreen {

	/**
	 * 
	 */
	public User user;
	/**
	 * 
	 */
	public String location;
	/**
	 * 
	 */
	public List<BloodDrive> bloodDrives;
	/**
	 * 
	 */
	public List<Notification> notifications;
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
	 * Getter of location
	 */
	public String getLocation() {
	 	 return location; 
	}
	/**
	 * Setter of location
	 */
	public void setLocation(String location) { 
		 this.location = location; 
	}
	/**
	 * Getter of bloodDrives
	 */
	public List<BloodDrive> getBloodDrives() {
	 	 return bloodDrives; 
	}
	/**
	 * Setter of bloodDrives
	 */
	public void setBloodDrives(List<BloodDrive> bloodDrives) { 
		 this.bloodDrives = bloodDrives; 
	}
	/**
	 * Getter of notifications
	 */
	public List<Notification> getNotifications() {
	 	 return notifications; 
	}
	/**
	 * Setter of notifications
	 */
	public void setNotifications(List<Notification> notifications) { 
		 this.notifications = notifications; 
	}
	/**
	 * 
	 */
	public void viewBloodDrives() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param bdId 
	 */
	public void selectBloodDrive(int bdId) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void viewNotifications() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param bdId 
	 * @param noteId 
	 */
	public void selectNotification(int bdId, int noteId) { 
		// TODO Auto-generated method
	 } 

}
