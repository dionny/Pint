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
	 * @param note 
	 * @param user 
	 */
	public void markSeen(Notification note, User user) { 
		// TODO Auto-generated method
	 } 

}
