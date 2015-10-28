package Data.Models;

public class User {

	/**
	 * 
	 */
	public String sessionKey;
	/**
	 * 
	 */
	public String emailAddress;
	/**
	 * 
	 */
	public String city;
	/**
	 * 
	 */
	public String state;
	/**
	 * 
	 */
	public String hashedPassword;
	/**
	 * 
	 */
	public int MaximumFailures = 4;
	/**
	 * 
	 */
	public int FailureCounter;
	/**
	 * 
	 */
	public long FirstFailureTimestamp;
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
	/**
	 * Getter of MaximumFailures
	 */
	public int getMaximumFailures() {
	 	 return MaximumFailures; 
	}
	/**
	 * Setter of MaximumFailures
	 */
	public void setMaximumFailures(int MaximumFailures) { 
		 this.MaximumFailures = MaximumFailures; 
	}
	/**
	 * Getter of FailureCounter
	 */
	public int getFailureCounter() {
	 	 return FailureCounter; 
	}
	/**
	 * Setter of FailureCounter
	 */
	public void setFailureCounter(int FailureCounter) { 
		 this.FailureCounter = FailureCounter; 
	}
	/**
	 * Getter of FirstFailureTimestamp
	 */
	public long getFirstFailureTimestamp() {
	 	 return FirstFailureTimestamp; 
	}
	/**
	 * Setter of FirstFailureTimestamp
	 */
	public void setFirstFailureTimestamp(long FirstFailureTimestamp) { 
		 this.FirstFailureTimestamp = FirstFailureTimestamp; 
	}
	/**
	 * 
	 */
	public void get() { 
		// TODO Auto-generated method
	 } 

}
