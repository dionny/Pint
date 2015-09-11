

import java.util.List;

public class UserController extends Controller {

	/**
	 * 
	 */
	public MobileLoginScreen mobileloginscreen;
	/**
	 * 
	 */
	public List<User> user;
	/**
	 * 
	 */
	public RegistrationScreen registrationscreen;
	/**
	 * 
	 */
	public HomeScreen homescreen;
	/**
	 * 
	 */
	public ManagerDashboard managerdashboard;
	/**
	 * Getter of mobileloginscreen
	 */
	public MobileLoginScreen getMobileloginscreen() {
	 	 return mobileloginscreen; 
	}
	/**
	 * Setter of mobileloginscreen
	 */
	public void setMobileloginscreen(MobileLoginScreen mobileloginscreen) { 
		 this.mobileloginscreen = mobileloginscreen; 
	}
	/**
	 * Getter of user
	 */
	public List<User> getUser() {
	 	 return user; 
	}
	/**
	 * Setter of user
	 */
	public void setUser(List<User> user) { 
		 this.user = user; 
	}
	/**
	 * 
	 * @param emailAddress 
	 * @param password 
	 * @return 
	 */
	public User authenticate(String password, String emailAddress) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * Getter of registrationscreen
	 */
	public RegistrationScreen getRegistrationscreen() {
	 	 return registrationscreen; 
	}
	/**
	 * Setter of registrationscreen
	 */
	public void setRegistrationscreen(RegistrationScreen registrationscreen) { 
		 this.registrationscreen = registrationscreen; 
	}
	/**
	 * Getter of homescreen
	 */
	public HomeScreen getHomescreen() {
	 	 return homescreen; 
	}
	/**
	 * Setter of homescreen
	 */
	public void setHomescreen(HomeScreen homescreen) { 
		 this.homescreen = homescreen; 
	}
	/**
	 * Getter of managerdashboard
	 */
	public ManagerDashboard getManagerdashboard() {
	 	 return managerdashboard; 
	}
	/**
	 * Setter of managerdashboard
	 */
	public void setManagerdashboard(ManagerDashboard managerdashboard) { 
		 this.managerdashboard = managerdashboard; 
	}
	/**
	 * 
	 * @param sessionKey 
	 * @return 
	 */
	public boolean endSession(String sessionKey) { 
		// TODO Auto-generated method
		return false;
	 }
	public boolean updateRoles(List<User> users) { 
		// TODO Auto-generated method
		return false;
	 }
	/**
	 * 
	 * @param user 
	 * @return 
	 */
	public boolean registerUser(User user) { 
		// TODO Auto-generated method
		return false;
	 } 

}