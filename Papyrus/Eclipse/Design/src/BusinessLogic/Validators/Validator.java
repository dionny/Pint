package BusinessLogic.Validators;

import Data.Models.User;

public abstract class Validator {

	/**
	 * Processes the validation of a requester
	 * @param user The user being validated
	 * @param request The request made by the user
	 */
	public void validate(User user, String request) { 
		// TODO Auto-generated method
	 }

	/**
	 * Validates the role of a requester
	 */
	public abstract void validatePermissions();

	/**
	 * Validates the identity of a requester
	 */
	public abstract void validateRequired(); 

}
