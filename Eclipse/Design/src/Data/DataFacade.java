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
	 * 
	 * @param city 
	 * @param state 
	 * @return 
	 */
	public BloodDrive getBloodDriveByLocation(String city, String state) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * 
	 * @param coordinator_id 
	 * @return 
	 */
	public BloodDrive getBloodDriveByCoordinator(int coordinator_id) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * 
	 * @param id 
	 * @return 
	 */
	public Notification getNotificationById(int id) { 
		// TODO Auto-generated method
		return null;
	 }

	/**
	 * 
	 * @param user_id 
	 * @param userNotification 
	 */
	public void getUserNotifications(int user_id, UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bloodDrive_id 
	 * @param userNotification 
	 */
	public void getUserNotificationsByBloodDrive(int bloodDrive_id, UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	public void getEmployees(int hospital_id, List<Employee> employees) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param hospital_id 
	 * @param hospital 
	 */
	public void getHospital(int hospital_id, Hospital hospital) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bloodDrive 
	 */
	public void createBloodDrive(BloodDrive bloodDrive) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param notification 
	 */
	public void createNotification(Notification notification) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param userNotification 
	 */
	public void createUserNotification(UserNotification userNotification) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param employee 
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
