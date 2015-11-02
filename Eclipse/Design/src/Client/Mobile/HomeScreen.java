package Client.Mobile;

import Data.Models.User;

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
