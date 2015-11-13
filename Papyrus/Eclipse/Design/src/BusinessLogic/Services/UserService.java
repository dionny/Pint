package BusinessLogic.Services;

import BusinessLogic.Validators.Validator;
import Data.Models.User;
import ECore.EJavaObject;

public class UserService {

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
	 * Get information about a user based on the user name
	 * @param username The string identifier of the user
	 * @return The user information
	 */
	public User getUser(String username) { 
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
	 * Creates a new employee
	 * @param data The information regarding the new employee
	 */
	public void createEmployee(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Get user information based on an email identifier
	 * @param email The email address of the user
	 */
	public void getUserByEmail(String email) { 
		// TODO Auto-generated method
	 }

	/**
	 * Updates information about a user
	 * @param user The user that is to be updated
	 */
	public void updateUser(User user) { 
		// TODO Auto-generated method
	 } 

}
