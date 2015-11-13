package Data.Models;

import java.util.List;

public class Hospital {

	/**
	 * 
	 */
	public int id;
	/**
	 * 
	 */
	public String name;
	/**
	 * 
	 */
	public List<BloodDrive> bloodDrive;
	/**
	 * Getter of id
	 */
	public int getId() {
	 	 return id; 
	}
	/**
	 * Setter of id
	 */
	public void setId(int id) { 
		 this.id = id; 
	}
	/**
	 * Getter of name
	 */
	public String getName() {
	 	 return name; 
	}
	/**
	 * Setter of name
	 */
	public void setName(String name) { 
		 this.name = name; 
	}
	/**
	 * Getter of bloodDrive
	 */
	public List<BloodDrive> getBloodDrive() {
	 	 return bloodDrive; 
	}
	/**
	 * Setter of bloodDrive
	 */
	public void setBloodDrive(List<BloodDrive> bloodDrive) { 
		 this.bloodDrive = bloodDrive; 
	} 

}
