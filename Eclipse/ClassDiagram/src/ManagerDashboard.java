

import java.util.List;

public class ManagerDashboard extends Screen {

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
	 * @param User 
	 * @param Role 
	 */
	public void changeRole(User User, int Role) { 
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