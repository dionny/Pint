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
	 * @return The user currently logged in.
	 */
	public User getUser() {
	 	 return user; 
	}
	/**
	 * Setter of user
	 * @param user The current user logged into the application.
	 */
	public void setUser(User user) { 
		 this.user = user; 
	}
	/**
	 * Getter of location
	 * @return The city and state of the current user.
	 */
	public String getLocation() {
	 	 return location; 
	}
	/**
	 * Setter of location
	 * @param location The city and state of the user logged into the application.
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
	 * @param bloodDrives The list of blood drives local to the user.
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
	 * @param notifications The list of notifications from local blood drives.
	 */
	public void setNotifications(List<Notification> notifications) { 
		 this.notifications = notifications; 
	}
	/**
	 * Retreives a list of local blood drives
	 */
	public void viewBloodDrives() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param bdId The blood drive id of a blood drive selected from a list of blood drives.
	 */
	public void selectBloodDrive(int bdId) { 
		// TODO Auto-generated method
	 }
	/**
	 * Retreives a list of notifications associated with local blood drives
	 */
	public void viewNotifications() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param bdId The id of the blood drive associated with the selected notification.
	 * @param noteId The id of the selected notification
	 */
	public void selectNotification(int bdId, int noteId) { 
		// TODO Auto-generated method
	 } 

}
