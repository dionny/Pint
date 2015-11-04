package Presentation;

import Presentation.ViewStrategies.ViewModelStrategy;

import java.util.List;

import Data.Models.User;
import ECore.EJavaObject;

public class RequestController {

	/**
	 * 
	 */
	public List<ViewModelStrategy> viewModelStrategy;
	/**
	 * 
	 */
	public List<User> sessions;
	/**
	 * Getter of viewModelStrategy
	 */
	public List<ViewModelStrategy> getViewModelStrategy() {
	 	 return viewModelStrategy; 
	}
	/**
	 * Setter of viewModelStrategy
	 */
	public void setViewModelStrategy(List<ViewModelStrategy> viewModelStrategy) { 
		 this.viewModelStrategy = viewModelStrategy; 
	}
	/**
	 * Getter of sessions
	 */
	public List<User> getSessions() {
	 	 return sessions; 
	}
	/**
	 * Setter of sessions
	 */
	public void setSessions(List<User> sessions) { 
		 this.sessions = sessions; 
	}
	/**
	 * Initiates the process of authneticating a user
	 * @param username The user name of the user being authenticated
	 * @param password The password of the user being authenticated
	 * @return The user or null if authentication fails
	 */
	public User authenticate(String username, String password) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * Submit a GET request
	 * @param data content of the GET request
	 */
	public void get(String data) { 
		// TODO Auto-generated method
	 }
	/**
	 * Convert a Java object into JSON
	 * @param object The objec that will be serialized
	 */
	public void serialize(EJavaObject object) { 
		// TODO Auto-generated method
	 }
	/**
	 * Submit a POST request
	 * @param data The content of the POST request
	 * @param success True if the request is successful, false otherwise
	 */
	public void post(String data, boolean success) { 
		// TODO Auto-generated method
	 }
	/**
	 * Checks that the currently logged in user has not timed-out
	 * @param user The user for which the time is being checked
	 */
	public void verifyUserTimer(User user) { 
		// TODO Auto-generated method
	 }
	/**
	 * Logs a user out
	 * @param user The user to be logged out
	 */
	public void logoutUser(User user) { 
		// TODO Auto-generated method
	 }
	/**
	 * Update the time for a user
	 * @param user The user for which the timer will be updated
	 */
	public void updateActiveTimer(User user) { 
		// TODO Auto-generated method
	 }
	/**
	 * Change the user view based on their platform
	 */
	public void changeView() { 
		// TODO Auto-generated method
	 } 

}
