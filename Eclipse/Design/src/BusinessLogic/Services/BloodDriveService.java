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
	 * Retreives a list of blood drives based on the location of a user
	 * @param user The user that will receive the list of blood drives
	 */
	public void getBloodDrives(User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Returns detailed information about a single blood drive
	 * @param bd The id of the blood drive to be returned
	 */
	public void getBloodDriveDetails(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Returns detailed information about a single blood drive
	 * @param bd The id of the blood drive to be returned
	 * @param user The user requesting the blood drive details
	 */
	public void getBloodDriveDetails(BloodDrive bd, User user) { 
		// TODO Auto-generated method
	 }

	/**
	 * Fetches a list of nurses not assigned to a particular blood drive
	 * @param user The user requesting the list
	 * @param bd The id of the relevant blood drive
	 */
	public void getUnassignedNurses(User user, BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Filters out assigned nurses for a blood drive
	 * @param bd The id of the relevant blood drive
	 */
	public void filterOutAssignedNurses(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	 /*
	 * Assigns nurses to a blood drive
	 * @param bd The id of the relevant blood drive
	 * @param nurses The nurses to be assigned to the blood drive
	 * @param success True if the nurses are assigned to the blood drive
	 */
	public void assignNurses(BloodDrive bd, List<Employee> nurses, boolean success) { 
		// TODO Auto-generated method
	 }

	/**
	 * Adds a count to the number of donors for a blood drive
	 * @param bd The id of the relevant blood drive
	 */
	public void incrementDonorCounter(BloodDrive bd) { 
		// TODO Auto-generated method
	 }

	/**
	 * Add a donor to a blood drive
	 * @param bd The id of the relevant blood drive
	 * @param email The email address of the donor
	 * @return True if the donor was added, False otherwise
	 */
	public boolean addDonor(BloodDrive bd, String email) { 
		// TODO Auto-generated method
		return false;
	 } 

}
