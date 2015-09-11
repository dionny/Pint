

import java.util.List;

public class ManagerDashboard {

	/**
	 * 
	 */
	public List<HospitalUser> hospitalUsers;
	/**
	 * 
	 */
	public UserController usercontroller;
	/**
	 * Getter of hospitalUsers
	 */
	public List<HospitalUser> getHospitalUsers() {
	 	 return hospitalUsers; 
	}
	/**
	 * Setter of hospitalUsers
	 */
	public void setHospitalUsers(List<HospitalUser> hospitalUsers) { 
		 this.hospitalUsers = hospitalUsers; 
	}
	/**
	 * Getter of usercontroller
	 */
	public UserController getUsercontroller() {
	 	 return usercontroller; 
	}
	/**
	 * Setter of usercontroller
	 */
	public void setUsercontroller(UserController usercontroller) { 
		 this.usercontroller = usercontroller; 
	}
	/**
	 * 
	 * @param Role 
	 * @param User 
	 */
	public void changeRole(int Role, User User) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public boolean saveRoles() { 
		// TODO Auto-generated method
		return false;
	 }
	/**
	 * 
	 * @param hospitalUser 
	 * @return 
	 */
	protected HospitalUser createHospitalUser(HospitalUser hospitalUser) { 
		// TODO Auto-generated method
		return null;
	 } 

}