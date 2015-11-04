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
	 * 
	 * @param bloodDrive 
	 */
	public void updateBloodDrive(BloodDrive bloodDrive) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param userNotification 
	 */
	public void updateUserNotification(UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param employee 
	 */
	public void updateEmployee(Employee employee) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param employee 
	 */
	public void deleteEmployee(Employee employee) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param email 
	 * @return 
	 */
	public User getUser(String email) { 
		// TODO Auto-generated method
		return null;
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
	 * @param id 
	 */
	public void getBloodDrive(int id) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param user 
	 * @param bd 
	 */
	public void getNotifications(User user, BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param user 
	 */
	public void getUserNotifications(User user) { 
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
	 * @param hospital_id 
	 */
	public void getAllNurses(int hospital_id) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param note 
	 * @param user 
	 */
	public void getUserNotification(Notification note, User user) { 
		// TODO Auto-generated method
	 } 

}
