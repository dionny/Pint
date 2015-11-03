package BusinessLogic;

import Data.Models.User;
import Data.Models.BloodDrive;
import Data.Models.Employee;
import Data.Models.Notification;
import ECore.EJavaObject;

public class BusinessLogicFacade {

	/**
	 * Authenticates a user attempting to access the application
	 * @param username the user name of the user
	 * @param password the password of the user
	 * @return An object containing user data or null if the authentication fails
	 */
	public User authenticate(String username, String password) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Locks a user out of the system due to repeated failures to enter correct password
	 * @param user The user that is to be locked out
	 */
	public void lockUser(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Retreives a list of blood drives based on the location of a user
	 * @param user The user that will receive the list of blood drives
	 */
	public void getBloodDrives(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Returns detailed information about a single blood drive
	 * @param bd The id of the blood drive to be returned
	 */
	public void getBloodDriveDetails(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Returns detailed information about a single blood drive
	 * @param bd The id of the blood drive to be returned
	 * @param user The user requesting the blood drive details
	 */
	public void getBloodDriveDetails(BloodDrive bd, User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Get notifications for a user
	 * @param user The user requesting the notifications
	 */
	public void getNotifications(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Creates a new employee
	 * @param data The information regarding the new employee
	 */
	public void createEmployee(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Get notifications associated with a single blood drive
	 * @param bd The id of the relevant blood drive
	 */
	public void getNotifications(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches a list of nurses not assigned to a particular blood drive
	 * @param user The user requesting the list
	 * @param bd The id of the relevant blood drive
	 */
	public void getUnassignedNurses(User user, BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Assigns nurses to a blood drive
	 * @param bd The id of the relevant blood drive
	 * @param nurses The nurse to be assigned to the blood drive
	 */
	public void assignNurses(BloodDrive bd, Employee nurses) { 
		// TODO Auto-generated method
	 }

	/**
	 * Get a user based on an email address
	 * @param email The email address of the user
	 */
	public void getUser(String email) { 
		// TODO Auto-generated method
	 }

	/**
	 * Add a donor to a blood drive
	 * @param bd The id of the relevant blood drive
	 * @param email The email address of the donor
	 */
	public void addDonor(BloodDrive bd, String email) { 
		// TODO Auto-generated method
	 }

	/**
	 * Updates information about a user
	 * @param user The user that is to be updated
	 */
	public void updateUser(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches a notification
	 * @param note The notification that is to be fetched
	 */
	public void selectNotification(Notification note) { 
		// TODO Auto-generated method
	 } 

}
