package Data;

import Data.Models.BloodDrive;
import Data.Models.Notification;
import Data.Models.UserNotification;
import java.util.List;
import Data.Models.Employee;
import Data.Models.Hospital;
import Data.Models.User;

public class DataFacade {

	/**
	 * 
	 */
	public static DataFacade Instance;

	/**
	 * Getter of Instance
	 */
	public DataFacade getInstance() {
	 	 return Instance; 
	}

	/**
	 * Setter of Instance
	 */
	public void setInstance(DataFacade Instance) { 
		 this.Instance = Instance; 
	}

	/**
	 * Get a list of blood drives based on a location
	 * @param city The name of the city
	 * @param state The name of the state
	 * @return The blood drives located in the city, State
	 */
	public BloodDrive getBloodDriveByLocation(String city, String state) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Get all blood drives owned by a coordinator
	 * @param coordinator_id The user id of the coordinator
	 * @return The blood drives owned by the coordinator
	 */
	public BloodDrive getBloodDriveByCoordinator(int coordinator_id) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Get a notification based on a notification id
	 * @param id The id of the notification
	 * @return The notification with the specified id
	 */
	public Notification getNotificationById(int id) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Fetches a list of notifications belonging to a user
	 * @param user_id The id of the user
	 * @param userNotification Not a clue
	 */
	public void getUserNotifications(int user_id, UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches a list of notifications belonging to a blood drive
	 * @param bloodDrive_id The id of the blood drive
	 * @param userNotification Why is this here?
	 */
	public void getUserNotificationsByBloodDrive(int bloodDrive_id, UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	/**
	* Fetches a list of employees belonging to a hopsital
	* @param hospital_id The id of the hospital
	*/
	public void getEmployees(int hospital_id, List<Employee> employees) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches information about a hospital
	 * @param hospital_id The id of the hospital
	 * @param hospital The hospital we are calling this function to acquire ??
	 */
	public void getHospital(int hospital_id, Hospital hospital) { 
		// TODO Auto-generated method
	 }

	/**
	 * Saves a new blood drive
	 * @param bloodDrive The object containing information about the new blood drive
	 */
	public void createBloodDrive(BloodDrive bloodDrive) { 
		// TODO Auto-generated method
	 }

	/**
	 * Saves a new notification
	 * @param notification The object containing information about the new notification
	 */
	public void createNotification(Notification notification) { 
		// TODO Auto-generated method
	 }

	/**
	 * Saves a new user notification
	 * @param userNotification The object containing information about the new user notification
	 */
	public void createUserNotification(UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	/**
	 * Saves a new employee
	 * @param employee The object containing information about the new employee
	 */
	public void createEmployee(Employee employee) { 
		// TODO Auto-generated method
	 }

	/**
	 * Updates the information about a blood drive
	 * @param bloodDrive The blood drive that will be updated
	 */
	public void updateBloodDrive(BloodDrive bloodDrive) { 
		// TODO Auto-generated method
	 }

	/**
	 * Updates the information about a user notification
	 * @param userNotification The user notification that will be updated
	 */
	public void updateUserNotification(UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	/**
	 * Updates the information about an employee
	 * @param employee The employee that will be updated
	 */
	public void updateEmployee(Employee employee) { 
		// TODO Auto-generated method
	 }

	/**
	 * Remove an employee from the application
	 * @param employee The employee that will be removed
	 */
	public void deleteEmployee(Employee employee) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches user data based on an email address
	 * @param email The email address of the desired user
	 * @return the user object that contains user information
	 */
	public User getUser(String email) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * Updates information about a user
	 * @param user The user that will be updated
	 */
	public void updateUser(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches blood drive information for a single blood drive
	 * @param id The id of the desired blood drive
	 */
	public void getBloodDrive(int id) { 
		// TODO Auto-generated method
	 }

	/**
	 * Get notifications from a blood drive
	 * @param user The user that requested the blood drives
	 * @param bd The blood drive that the user is viewing
	 */
	public void getNotifications(User user, BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Get all notifications for a user
	 * @param user The user requesting the notifications
	 */
	public void getUserNotifications(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Get all notifications for a blood drive
	 * @param bd The relevant blood drive
	 */
	public void getNotifications(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches a list of all nurses at a hospital
	 * @param hospital_id The id of the relevant hospital
	 */
	public void getAllNurses(int hospital_id) { 
		// TODO Auto-generated method
	 }

	/**
	 * Gets a user notification based on a notification
	 * @param note The notification of interest
	 * @param user The user for which a user notification is requested
	 */
	public void getUserNotification(Notification note, User user) { 
		// TODO Auto-generated method
	 } 

}
