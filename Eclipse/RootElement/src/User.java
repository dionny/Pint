

/**
 * http://download.eclipse.org/mmt/qvto/updates/releases
 * @author
 */
public class User extends Entity {

	/**
	 * 
	 */
	public String sessionKey;
	/**
	 * 
	 */
	public UserController usercontroller;
	/**
	 * 
	 */
	public String city;
	/**
	 * 
	 */
	public String emailAddress;
	/**
	 * 
	 */
	public String state;
	/**
	 * 
	 */
	public String hashedPassword;
	/**
	 * Getter of sessionKey
	 */
	public String getSessionKey() {
	 	 return sessionKey; 
	}
	/**
	 * Setter of sessionKey
	 */
	public void setSessionKey(String sessionKey) { 
		 this.sessionKey = sessionKey; 
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
	 * Getter of city
	 */
	public String getCity() {
	 	 return city; 
	}
	/**
	 * Setter of city
	 */
	public void setCity(String city) { 
		 this.city = city; 
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
	 * Getter of state
	 */
	public String getState() {
	 	 return state; 
	}
	/**
	 * Setter of state
	 */
	public void setState(String state) { 
		 this.state = state; 
	}
	/**
	 * Getter of hashedPassword
	 */
	public String getHashedPassword() {
	 	 return hashedPassword; 
	}
	/**
	 * Setter of hashedPassword
	 */
	public void setHashedPassword(String hashedPassword) { 
		 this.hashedPassword = hashedPassword; 
	} 

}