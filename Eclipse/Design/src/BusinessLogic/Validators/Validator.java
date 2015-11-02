package BusinessLogic.Validators;

import Data.Models.User;

public abstract class Validator {

	/**
	 * 
	 * @param user 
	 * @param request 
	 */
	public void validate(User user, String request) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 */
	public abstract void validatePermissions();

	/**
	 * 
	 */
	public abstract void validateRequired(); 

}
