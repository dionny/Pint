package BusinessLogic.Services;

import BusinessLogic.Validators.Validator;
import Data.Models.User;
import Data.Models.BloodDrive;
import Data.Models.Notification;

public class NotificationService {

	/**
	 * 
	 */
	public Validator validator;

	/**
	 * Getter of validator
	 */
	public Validator getValidator() {
	 	 return validator; 
	}

	/**
	 * Setter of validator
	 */
	public void setValidator(Validator validator) { 
		 this.validator = validator; 
	}

	/**
	 * Fetches a list of notifications
	 * @param user user The user requesting the list
	 * @param bd The id of the relevant blood drive
	 */
	public void getNotifications(User user, BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches a list of notification information for a user
	 * @param user the user requesting the list
	 */
	public void getUserNotifications(User user) { 
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
	 * Marks a notification as seen by the user
	 * @param note the notification to be marked
	 * @param user The user that owns the notification
	 */
	public void markSeen(Notification note, User user) { 
		// TODO Auto-generated method
	 } 

}
