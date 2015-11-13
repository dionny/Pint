package Data.Repositories;

import ECore.EJavaObject;

public abstract class Repository {

	/**
	 * Executes a read request
	 * @param id 
	 * @param object 
	 */
	public void get(int id, EJavaObject object) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes an update request
	 * @param data 
	 */
	public void update(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes a delete request
	 * @param data 
	 */
	public void delete(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes a write request
	 * @param data 
	 */
	public void create(EJavaObject data) { 
		// TODO Auto-generated method
	 }

	/**
	 * Executes a read request
	 * @param id 
	 * @param object 
	 */
	public void get(String id, EJavaObject object) { 
		// TODO Auto-generated method
	 } 

}
