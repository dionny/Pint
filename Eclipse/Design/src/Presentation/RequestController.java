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
	 * 
	 * @param username 
	 * @param password 
	 * @return 
	 */
	public User authenticate(String username, String password) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param data 
	 */
	public void get(String data) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param object 
	 */
	public void serialize(EJavaObject object) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param data 
	 * @param success 
	 */
	public void post(String data, boolean success) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param user 
	 */
	public void verifyUserTimer(User user) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param user 
	 */
	public void logoutUser(User user) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param user 
	 */
	public void updateActiveTimer(User user) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void changeView() { 
		// TODO Auto-generated method
	 } 

}
