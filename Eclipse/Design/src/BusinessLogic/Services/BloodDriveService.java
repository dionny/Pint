package BusinessLogic.Services;

import BusinessLogic.Validators.Validator;
import Data.Models.User;
import Data.Models.BloodDrive;
import Data.Models.Employee;

public class BloodDriveService {

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
	 * @param bd 
	 */
	public void getUnassignedNurses(User user, BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param bd 
	 */
	public void filterOutAssignedNurses(BloodDrive bd) { 
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
	 * @param bd 
	 */
	public void incrementDonorCounter(BloodDrive bd) { 
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

}
