//package com.pint.entity;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//public class Users {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long userId;
//
//	@NotNull
//	@Size(min = 1, max = 200)
//	private String sessionKey;
//
//	@NotNull
//	@Size(min = 1, max = 100)
//	private String emailAddress;
//
//
//	@NotNull
//	@Size(min = 1, max = 50)
//	private String city;
//
//	@NotNull
//	@Size(min = 1, max = 50)
//	private String state;
//
//	@NotNull
//	private int zip;
//
//	@NotNull
//	@Size(min = 1, max = 200)
//	private String hashedPassword;
//
//	@NotNull
//	private int MaximumFailures = 3;
//
//	@NotNull
//	public  int FailureCounter;
//
//	@NotNull
//	@Column(name = "firstFailTime", insertable=false)
//	private Date firstFailTime;
//
//
//
//
//	public Users(long id, String sessionKey, String emailAddress,String city, String state,String hashedPassword) {
//		this.userId = id;
//		this.sessionKey = sessionKey;
//		this.emailAddress = emailAddress;
//		this.city = city;
//		this.state = state;
//	}
//
//
//	public long getId() {
//		return userId;
//	}
//
//	public String getContent()  {
//
//		/*JSONObject User = new JSONObject();
//
//    	User.put("id", 1);
//    	User.put("emailAddress", "anjlichhatwani");
//    	User.put("state", "achha004@fiu.edu");
//    	return User;
//		 */
//
//
//		return	"sessionKey :=== " + sessionKey + " emailAddress :" +emailAddress + " city :" + city + " state :" + state + " hashedPassword :" + hashedPassword + " MaximumFailures :" + MaximumFailures + " FailureCounter :" + FailureCounter + "FirstFailureTimestamp :" ;
//	}
//
//
//	public String getSessionKey() {
//		return sessionKey;
//	}
//	/**
//	 * Setter of sessionKey
//	 */
//	public void setSessionKey(String sessionKey) {
//		this.sessionKey = sessionKey;
//	}
//	/**
//	 * Getter of emailAddress
//	 */
//	public String getEmailAddress() {
//		return emailAddress;
//	}
//	/**
//	 * Setter of emailAddress
//	 */
//	public void setEmailAddress(String emailAddress) {
//		this.emailAddress = emailAddress;
//	}
//	/**
//	 * Getter of city
//	 */
//	public String getCity() {
//		return city;
//	}
//	/**
//	 * Setter of city
//	 */
//	public void setCity(String city) {
//		this.city = city;
//	}
//	/**
//	 * Getter of state
//	 */
//	public String getState() {
//		return state;
//	}
//	/**
//	 * Setter of state
//	 */
//	public void setState(String state) {
//		this.state = state;
//	}
//	/**
//	 * Getter of hashedPassword
//	 */
//	public String getHashedPassword() {
//		return hashedPassword;
//	}
//	/**
//	 * Setter of hashedPassword
//	 */
//	public void setHashedPassword(String hashedPassword) {
//		this.hashedPassword = hashedPassword;
//	}
//	/**
//	 * Getter of MaximumFailures
//	 */
//	public int getMaximumFailures() {
//		return MaximumFailures;
//	}
//	/**
//	 * Setter of MaximumFailures
//	 */
//	public void setMaximumFailures(int MaximumFailures) {
//		this.MaximumFailures = MaximumFailures;
//	}
//	/**
//	 * Getter of FailureCounter
//	 */
//	public int getFailureCounter() {
//		return FailureCounter;
//	}
//	/**
//	 * Setter of FailureCounter
//	 */
//	public void setFailureCounter(int FailureCounter) {
//		this.FailureCounter = FailureCounter;
//	}
//	/**
//	 * Getter of FirstFailureTimestamp
//	 */
//	public Date getFirstFailureTimestamp() {
//		return firstFailTime;
//	}
//	/**
//	 * Setter of FirstFailureTimestamp
//	 */
//	public void setFirstFailureTimestamp(Date firstFailTime) {
//		this.firstFailTime = firstFailTime;
//	}
//	/**
//	 *
//	 */
//	public void get() {
//		// TODO Auto-generated method
//	}
//}
