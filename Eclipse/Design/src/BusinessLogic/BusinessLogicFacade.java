package BusinessLogic;

import Data.Models.User;
import Data.Models.BloodDrive;
import Data.Models.Employee;
import Data.Models.Notification;
import ECore.EJavaObject;

public class BusinessLogicFacade {

	/**
	 * 
	 * @param username 
	 * @param password 
	 * @return 
	 */
	public User authenticate(String username, String password) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * 
	 * @param user 
	 */
	public void lockUser(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param user 
	 */
	public void getBloodDrives(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bd 
	 */
	public void getBloodDriveDetails(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bd 
	 * @param user 
	 */
	public void getBloodDriveDetails(BloodDrive bd, User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param user 
	 */
	public void getNotifications(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param data 
	 */
	public void createEmployee(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bd 
	 */
	public void getNotifications(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param user 
	 * @param bd 
	 */
	public void getUnassignedNurses(User user, BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bd 
	 * @param nurses 
	 */
	public void assignNurses(BloodDrive bd, Employee nurses) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param email 
	 */
	public void getUser(String email) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bd 
	 * @param email 
	 */
	public void addDonor(BloodDrive bd, String email) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param user 
	 */
	public void updateUser(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param note 
	 */
	public void selectNotification(Notification note) { 
		// TODO Auto-generated method
	 } 

}
