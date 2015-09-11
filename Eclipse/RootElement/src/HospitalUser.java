

/**
 * http://download.eclipse.org/mmt/qvto/updates/releases
 * @author
 */
public class HospitalUser extends User {

	/**
	 * 
	 */
	public int role;
	/**
	 * 
	 */
	public int hospitalId;
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

}