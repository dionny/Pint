package Data.Models;

public class Employee extends User {

	/**
	 * 
	 */
	public int role;
	/**
	 * 
	 */
	public String firstName;
	/**
	 * 
	 */
	public String lastName;
	/**
	 * 
	 */
	public Hospital hospital;
	/**
	 * 
	 */
	public String phoneNumber;
	/**
	 * Getter of role
	 */
	public int getRole() {
	 	 return role; 
	}
	/**
	 * Setter of role
	 */
	public void setRole(int role) { 
		 this.role = role; 
	}
	/**
	 * Getter of firstName
	 */
	public String getFirstName() {
	 	 return firstName; 
	}
	/**
	 * Setter of firstName
	 */
	public void setFirstName(String firstName) { 
		 this.firstName = firstName; 
	}
	/**
	 * Getter of lastName
	 */
	public String getLastName() {
	 	 return lastName; 
	}
	/**
	 * Setter of lastName
	 */
	public void setLastName(String lastName) { 
		 this.lastName = lastName; 
	}
	/**
	 * Getter of hospital
	 */
	public Hospital getHospital() {
	 	 return hospital; 
	}
	/**
	 * Setter of hospital
	 */
	public void setHospital(Hospital hospital) { 
		 this.hospital = hospital; 
	}
	/**
	 * Getter of phoneNumber
	 */
	public String getPhoneNumber() {
	 	 return phoneNumber; 
	}
	/**
	 * Setter of phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) { 
		 this.phoneNumber = phoneNumber; 
	} 

}
