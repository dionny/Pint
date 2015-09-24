

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
	 * 
	 */
	public String emailAddress;
	/**
	 * 
	 */
	public String password;
	/**
	 * 
	 */
	public String passwordConfirmation;
	/**
	 * 
	 */
	public String role;
	/**
	 * 
	 */
	public String contactNumber;
	/**
	 * 
	 */
	public String firstName;
	/**
	 * 
	 */
	public String lastName;
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
	/**
	 * Getter of emailAddress
	 */
	public String getEmailAddress() {
	 	 return emailAddress; 
	}
	/**
	 * Setter of emailAddress
	 */
	public void setEmailAddress(String emailAddress) { 
		 this.emailAddress = emailAddress; 
	}
	/**
	 * Getter of password
	 */
	public String getPassword() {
	 	 return password; 
	}
	/**
	 * Setter of password
	 */
	public void setPassword(String password) { 
		 this.password = password; 
	}
	/**
	 * Getter of passwordConfirmation
	 */
	public String getPasswordConfirmation() {
	 	 return passwordConfirmation; 
	}
	/**
	 * Setter of passwordConfirmation
	 */
	public void setPasswordConfirmation(String passwordConfirmation) { 
		 this.passwordConfirmation = passwordConfirmation; 
	}
	/**
	 * Getter of role
	 */
	public String getRole() {
	 	 return role; 
	}
	/**
	 * Setter of role
	 */
	public void setRole(String role) { 
		 this.role = role; 
	}
	/**
	 * Getter of contactNumber
	 */
	public String getContactNumber() {
	 	 return contactNumber; 
	}
	/**
	 * Setter of contactNumber
	 */
	public void setContactNumber(String contactNumber) { 
		 this.contactNumber = contactNumber; 
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
	 * 
	 * @param employee 
	 * @return 
	 */
	public Employee createEmployee(Employee employee) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 */
	public void createEmployeePopup() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void confirmCreateEmployee() { 
		// TODO Auto-generated method
	 } 

}