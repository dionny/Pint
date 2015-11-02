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
	 * 
	 * @param username 
	 * @return 
	 */
	public User getUser(String username) { 
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
	 * @param data 
	 */
	public void createEmployee(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param email 
	 */
	public void getUserByEmail(String email) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param user 
	 */
	public void updateUser(User user) { 
		// TODO Auto-generated method
	 } 

}
