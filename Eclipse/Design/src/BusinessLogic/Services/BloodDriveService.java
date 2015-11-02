package BusinessLogic.Services;

import BusinessLogic.Validators.Validator;
import Data.Models.User;
import Data.Models.BloodDrive;
import java.util.List;
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

	public void assignNurses(BloodDrive bd, List<Employee> nurses, boolean success) { 
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
	 * @return 
	 */
	public boolean addDonor(BloodDrive bd, String email) { 
		// TODO Auto-generated method
		return false;
	 } 

}
