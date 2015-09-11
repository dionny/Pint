

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
	 * @param password 
	 * @param emailAddress 
	 * @return 
	 */
	public User authenticate(String password, String emailAddress) { 
		// TODO Auto-generated method
		return null;
	 } 

}