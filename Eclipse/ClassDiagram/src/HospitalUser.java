

/**
 * http://download.eclipse.org/mmt/qvto/updates/releases
 * @author
 */
public class HospitalUser extends User {

	/**
	 * 
	 */
	public int hospitalId;
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
	 * Getter of hospitalId
	 */
	public int getHospitalId() {
	 	 return hospitalId; 
	}
	/**
	 * Setter of hospitalId
	 */
	public void setHospitalId(int hospitalId) { 
		 this.hospitalId = hospitalId; 
	}
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

}